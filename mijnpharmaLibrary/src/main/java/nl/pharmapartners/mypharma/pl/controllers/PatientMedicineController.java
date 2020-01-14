package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.dal.repository.*;
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
    private ATCRuleRepository atcRuleRepository;
    @Autowired
    private PRKRuleRepository prkRuleRepository;
    @Autowired
    private DosageRuleRepository dosageRuleRepository;
    @Autowired
    private PatientRuleRepository patientRuleRepository;
    @Autowired
    private DurationRuleRepository durationRuleRepository;
    @Autowired
    private MedicineRepository medicineRepository;

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

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        user = optionalUser.get();

        return patientMedicineRepository.findByUser(user);
    }

    @PostMapping(path = "/addMedicine/{token}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicineToUserList(@RequestBody PatientMedicine patientMedicine, @RequestHeader("medicine") String id, @PathVariable String token) {
        User user = new User();
        user.setToken(token);
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        Medicine medicine = optionalMedicine.get();

        patientMedicine.setMedicine(medicine);

        user = optionalUser.get();
        patientMedicine.setUser(user);

        patientMedicineRepository.save(patientMedicine);
    }

    @GetMapping(path = "/diagnosis", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnosis getDiagnosis(@RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        return generateDiagnosis(token);
    }
  
    @PostMapping(path = "/removeMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeMedicineFromUserList(@RequestBody PatientMedicine patientMedicine) {
        patientMedicineRepository.delete(patientMedicine);
    }
  
    private Diagnosis generateDiagnosis(String token) {
        List<RuleSet> ruleSets = new ArrayList<>();
        //get patient
        User user = new User();
        user.setToken(token);
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        user = optionalUser.get();

//        patientMedicine.setMedicine(medicine);
        user = optionalUser.get();
//        patientMedicine.setUser(user);

        Patient patient = patientRepository.findById(user.getId()).get();
        patient.setMedicineList(getPatientMedicine(user.getToken()));

        //get rulesets for all medication
        for (PatientMedicine m : patient.getMedicineList()) {
            RuleSet ruleSet = ruleSetRepository.findById(m.getMedicine().getId()).get();
            String medicineId = ruleSet.getMedicineId();

            ruleSet.getATCRuleList().add(atcRuleRepository.findById(medicineId).get());
            ruleSet.getPRKRuleList().add(prkRuleRepository.findById(medicineId).get());
            ruleSet.getDosageRuleList().add(dosageRuleRepository.findById(medicineId).get());
            ruleSet.getPatientRuleList().add(patientRuleRepository.findById(medicineId).get());
            ruleSet.getDurationRuleList().add(durationRuleRepository.findById(medicineId).get());

            //add ruleset to list
            ruleSets.add(ruleSet);
        }

        //only execute if rulesets are present
        if (ruleSets.size() > 0) {
            Executor executor = new Executor(ruleSets, patient);
            return executor.generateDiagnosis();
        }
        return new Diagnosis();
    }
}
