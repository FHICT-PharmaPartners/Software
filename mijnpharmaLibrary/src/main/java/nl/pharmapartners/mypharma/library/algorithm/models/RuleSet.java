package nl.pharmapartners.mypharma.library.algorithm.models;

import nl.pharmapartners.mypharma.library.model.*;

import java.util.List;

public class RuleSet {
    private Patient patient;
    private List<PatientRule> patientRuleList;
    private List<PRKRule> prkRuleList;
    private List<Medication> dosageRule;
    private List<Medication> durationRule;
    private List<ATCRule> atcRuleList;

    public RuleSet(Patient patient, List<PatientRule> patientRuleList, List<PRKRule> prkRuleList, List<ATCRule> atcRuleList) {
        this.patient = patient;
        this.patientRuleList = patientRuleList;
        this.prkRuleList = prkRuleList;
        this.atcRuleList = atcRuleList;
    }
}
