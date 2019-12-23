package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.PatientRepository;
import nl.pharmapartners.mypharma.library.dal.repository.RuleSetRepository;
import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.Diagnosis;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/checkAllMedicine/{id}")
    public Diagnosis checkAllMedicine(@PathVariable String id) {
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
