package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.Diagnosis;
import nl.pharmapartners.mypharma.library.model.Patient;

public class AlgorithmThread implements Runnable {
    private Algorithm algorithm = new Algorithm();
    private Diagnosis diagnosis;
    private RuleSet ruleSet;
    private Patient patient;

    public AlgorithmThread(RuleSet ruleSet, Patient patient) {
        this.ruleSet = ruleSet;
        this.patient = patient;
    }

    @Override
    public void run() {
        diagnosis = algorithm.run(ruleSet, patient);
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
