package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.dal.repository.*;
import nl.pharmapartners.mypharma.library.model.RuleSet;
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
    private ATCRuleRepository atcRuleRepository;
    private PRKRuleRepository prkRuleRepository;
    private DosageRuleRepository dosageRuleRepository;
    private DurationRuleRepository durationRuleRepository;
    private PatientRuleRepository patientRuleRepository;

    @Autowired
    private void setPatientMedicineRepository(PatientMedicineRepository patientMedicineRepository,
                                              PatientRepository patientRepository,
                                              RuleSetRepository ruleSetRepository,
                                              ATCRuleRepository atcRuleRepository,
                                              PRKRuleRepository prkRuleRepository,
                                              DosageRuleRepository dosageRuleRepository,
                                              DurationRuleRepository durationRuleRepository,
                                              PatientRuleRepository patientRuleRepository) {
        this.patientMedicineRepository = patientMedicineRepository;
        this.patientRepository = patientRepository;
        this.ruleSetRepository = ruleSetRepository;
        this.atcRuleRepository = atcRuleRepository;
        this.prkRuleRepository = prkRuleRepository;
        this.dosageRuleRepository = dosageRuleRepository;
        this.durationRuleRepository = durationRuleRepository;
        this.patientRuleRepository = patientRuleRepository;
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
        //debug methode
        Diagnosis diagnosis = generateDiagnosis(id);
        return generateDiagnosis(id);
    }

    private Diagnosis generateDiagnosis(String id) {
        List<RuleSet> ruleSets = new ArrayList<>();
        //get patient
        Patient patient = patientRepository.findById(id).get();
        patient.setMedicineList(getAllPatientMedicine());
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
