package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.PatientRepository;
import nl.pharmapartners.mypharma.library.dal.repository.RuleSetRepository;
import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patientMedicine")
public class PatientMedicineController {

    private PatientMedicineRepository patientMedicineRepository;
    private PatientRepository patientRepository;
    private RuleSetRepository ruleSetRepository;
    private UserRepository userRepository;

    @Autowired
    private void setPatientMedicineRepository(PatientMedicineRepository patientMedicineRepository,
                                              PatientRepository patientRepository,
                                              RuleSetRepository ruleSetRepository,
                                              UserRepository userRepository) {
        this.patientMedicineRepository = patientMedicineRepository;
        this.patientRepository = patientRepository;
        this.ruleSetRepository = ruleSetRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/patient/{token}")
    public List<PatientMedicine> getPatientMedicine(@PathVariable String token) {

        User user = new User();
        user.setToken(token);
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        user = optionalUser.get();

        return patientMedicineRepository.findByUser(user);
    }

    @PostMapping(path = "/addMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicineToUserList(@RequestBody PatientMedicine patientMedicine) {
        patientMedicineRepository.save(patientMedicine);
        generateDiagnosis(patientMedicine.getId());
    }

    private Diagnosis generateDiagnosis(String id) {
        List<RuleSet> ruleSets = new ArrayList<>();
        //get patient
        Patient patient = patientRepository.findById(id).get();
        //get rulesets for all medication
        for (PatientMedicine m : patient.getMedicineList()) {
            ruleSets.add(ruleSetRepository.findById(m.getMedicine().getId()).get());
        }
        Executor executor = new Executor(ruleSets, patient);
        return executor.checkAll();
    }
}
