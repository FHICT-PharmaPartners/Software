package nl.pharmapartners.mypharma.library.algorithm.models;

import nl.pharmapartners.mypharma.library.model.*;

import java.util.List;

public class RuleSet {
    private int MFBId;
    private Patient patient;
    private List<PatientRule> patientRuleList;
    private List<PRKRule> PRKRuleList;
    private List<Medication> dosageRule;
    private List<Medication> durationRule;
    private List<ATCRule> ATCRuleList;

    public int getMFBId() {
        return MFBId;
    }

    public void setMFBId(int MFBId) {
        this.MFBId = MFBId;
    }

    public RuleSet(List<PatientRule> patientRuleList, List<PRKRule> PRKRuleList, List<ATCRule> ATCRuleList) {
        this.patientRuleList = patientRuleList;
        this.PRKRuleList = PRKRuleList;
        this.ATCRuleList = ATCRuleList;
    }

    public RuleSet(Patient patient, List<PatientRule> patientRuleList, List<PRKRule> PRKRuleList, List<ATCRule> ATCRuleList) {
        this.patient = patient;
        this.patientRuleList = patientRuleList;
        this.PRKRuleList = PRKRuleList;
        this.ATCRuleList = ATCRuleList;
    }

    public List<PatientRule> getPatientRuleList() {
        return patientRuleList;
    }

    public List<PRKRule> getPRKRuleList() {
        return PRKRuleList;
    }

    public List<Medication> getDosageRule() {
        return dosageRule;
    }

    public List<Medication> getDurationRule() {
        return durationRule;
    }

    public List<ATCRule> getATCRuleList() {
        return ATCRuleList;
    }
}
