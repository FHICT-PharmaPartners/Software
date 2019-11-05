package nl.pharmapartners.mypharma.library.algorithm.models;

import nl.pharmapartners.mypharma.library.model.*;

import java.util.List;

public class RuleSet {
    private Patient patient;
    private List<PatientRule> patientRuleList;
    private List<PRKRule> PRKRuleList;
    private List<Medication> dosageRule;
    private List<Medication> durationRule;
    private List<ATCRule> ATCRuleList;

    public RuleSet(Patient patient, List<PatientRule> patientRuleList, List<PRKRule> PRKRuleList, List<ATCRule> ATCRuleList) {
        this.patient = patient;
        this.patientRuleList = patientRuleList;
        this.PRKRuleList = PRKRuleList;
        this.ATCRuleList = ATCRuleList;
    }
}
