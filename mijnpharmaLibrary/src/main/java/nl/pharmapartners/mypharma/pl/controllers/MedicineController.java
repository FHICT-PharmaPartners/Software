package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.MedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "http://localhost:1800", maxAge = 3600)
public class MedicineController {

    private MedicineRepository medicineRepository;
    private PatientMedicineRepository patientMedicineRepository;
    private UserRepository userRepository;

    @Autowired
    private void setMedicineRepository(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Autowired
    private void setPatientMedicineRepository(PatientMedicineRepository patientMedicineRepository,
                                              UserRepository userRepository) {
        this.patientMedicineRepository = patientMedicineRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/getAll/{token}")
    public List<Medicine> getAllMedicine(@PathVariable String token) {
        User user = new User();
        user.setToken(token);
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        user = optionalUser.get();

        List<PatientMedicine> patientMedicineList = patientMedicineRepository.findByUser(user);
        List<Medicine> allMedicineList = medicineRepository.findAll();

        for (Iterator<Medicine> it = allMedicineList.iterator(); it.hasNext();) {
            Medicine m = it.next();
            for(PatientMedicine pm : patientMedicineList){
                if(m.getId().equals(pm.getMedicine().getId())){
                    it.remove();
                }
            }
        }

        return allMedicineList;
    }

    @GetMapping(value = "/getByName/{name}")
    public List<Medicine> getMedicineByName(@PathVariable String name) {
        return null;
    }

    @GetMapping(value = "/getById/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable("id") String id) {
        return medicineRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicine(@RequestBody Medicine medicine) {
        medicineRepository.save(medicine);
    }
}
