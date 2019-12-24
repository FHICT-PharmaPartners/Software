package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.model.RuleSet;
import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.PatientRepository;
import nl.pharmapartners.mypharma.library.dal.repository.RuleSetRepository;
import nl.pharmapartners.mypharma.library.model.Diagnosis;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patientMedicine")
public class PatientMedicineController {

    private PatientMedicineRepository patientMedicineRepository;
    private PatientRepository patientRepository;
    private RuleSetRepository ruleSetRepository;

    @Autowired
    private void setPatientMedicineRepository(PatientMedicineRepository patientMedicineRepository,
                                              PatientRepository patientRepository,
                                              RuleSetRepository ruleSetRepository) {
        this.patientMedicineRepository = patientMedicineRepository;
        this.patientRepository = patientRepository;
        this.ruleSetRepository = ruleSetRepository;
    }

    @GetMapping()
    public List<PatientMedicine> getAllPatientMedicine() {
        return patientMedicineRepository.findAll();
    }

    @PostMapping(path = "/addMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicineToUserList(@RequestBody PatientMedicine patientMedicine) {
        patientMedicineRepository.save(patientMedicine);
    }

    @GetMapping(path = "/getDiagnosis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnosis getDiagnosis(@PathVariable String id) {
        return generateDiagnosis(id);
    }

    private Diagnosis generateDiagnosis(String id) {
        List<RuleSet> ruleSets = new ArrayList<>();
        //get patient
        Patient patient = patientRepository.findById(id).get();
        patient.setMedicineList(getAllPatientMedicine());
        //get rulesets for all medication
        for (PatientMedicine m : patient.getMedicineList()) {
            ruleSets.add(ruleSetRepository.findById(m.getMedicine().getId()).get());
            //ruleset lists vullen met regels uit db
        }

        //only execute if rulesets are present
        if (ruleSets.size() > 0) {
            Executor executor = new Executor(ruleSets, patient);
            return executor.generateDiagnosis();
        }
        return new Diagnosis();
    }
}
