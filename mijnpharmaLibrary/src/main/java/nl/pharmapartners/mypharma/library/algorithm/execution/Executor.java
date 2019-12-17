package nl.pharmapartners.mypharma.library.algorithm.execution;

import javafx.css.Rule;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.Diagnosis;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import nl.pharmapartners.mypharma.library.model.PatientRule;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    private Algorithm algorithm;
    private Patient patient;

    public Executor(Patient patient) {
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
        //issues worden niet overgezet
        for (Diagnosis d : diagnoses){
            if(!d.isPassed()){
                finalDiagnosis.setPassed(false);
            }
            finalDiagnosis.getIssues().addAll(d.getIssues());
        }

        return finalDiagnosis;
    }

    private RuleSet getRuleSet(String id){
        /**
         * Get ruleset by medicine id
         */

        //hardcoded ruleset for demo REMOVE ASAP
        RuleSet ruleSet = new RuleSet();
        ruleSet.setATCRuleList(new ArrayList<>());
        ruleSet.setDosageRuleList(new ArrayList<>());
        ruleSet.setDurationRuleList(new ArrayList<>());
        ruleSet.setPRKRuleList(new ArrayList<>());
        List<PatientRule> patientRules = new ArrayList<>();
        PatientRule patientRule = new PatientRule();
        PatientRule patientRule2 = new PatientRule();

        patientRule.setAge(75);
        patientRule.setOperator(1);

        patientRule2.setWeight(80);
        patientRule2.setOperator(1);

        patientRules.add(patientRule);
        patientRules.add(patientRule2);

        ruleSet.setPatientRuleList(patientRules);

        return ruleSet;
    }
}
