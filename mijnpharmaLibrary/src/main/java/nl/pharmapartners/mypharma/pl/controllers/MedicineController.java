package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineRepository medicineRepository;

    @Autowired
    private void setMedicineRepository(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }

    @GetMapping()
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    @GetMapping(value = "/getByName/{name}")
    public List<Medicine> getMedicineByName(@PathVariable String name){
        return null;
    }

    @GetMapping(value = "/getById/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable("id") String id){
        return medicineRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicine(@RequestBody Medicine medicine){
        medicineRepository.save(medicine);
    }
}
