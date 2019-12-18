package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    private Algorithm algorithm;
    private Patient patient;
    private List<RuleSet> ruleSets;

    public Executor(List<RuleSet> ruleSets, Patient patient) {
        this.ruleSets = ruleSets;
        this.patient = patient;
        algorithm = new Algorithm();
    }

    public Diagnosis checkAll(){
        List<Diagnosis> diagnoses = new ArrayList<>();
        Diagnosis finalDiagnosis = new Diagnosis();
        finalDiagnosis.setPassed(true);
        finalDiagnosis.setIssues(new ArrayList<>());

        //run algorithm for each medicine
        for (PatientMedicine m : patient.getMedicineList()){
            diagnoses.add(algorithm.run(getRuleSet(m.getMedicine().getId()), patient));
        }

        //merge diagnoses to one final diagnosis
        for (Diagnosis d : diagnoses){
            if(!d.isPassed()){
                finalDiagnosis.setPassed(false);
            }
            finalDiagnosis.getIssues().addAll(d.getIssues());
        }

        return finalDiagnosis;
    }

    private RuleSet getRuleSet(String id){
        for (RuleSet r : ruleSets){
            if (r.getMedicineId().equals(id)){
                return r;
            }
        }
        return null;
    }
}
