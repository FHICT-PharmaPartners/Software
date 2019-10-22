package Algorithm;

import DAL.Models.*;

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<PatientRule> getPatientRuleList() {
        return patientRuleList;
    }

    public void setPatientRuleList(List<PatientRule> patientRuleList) {
        this.patientRuleList = patientRuleList;
    }

    public List<PRKRule> getPrkRuleList() {
        return prkRuleList;
    }

    public void setPrkRuleList(List<PRKRule> prkRuleList) {
        this.prkRuleList = prkRuleList;
    }

    public List<Medication> getDosageRule() {
        return dosageRule;
    }

    public void setDosageRule(List<Medication> dosageRule) {
        this.dosageRule = dosageRule;
    }

    public List<Medication> getDurationRule() {
        return durationRule;
    }

    public void setDurationRule(List<Medication> durationRule) {
        this.durationRule = durationRule;
    }

    public List<ATCRule> getAtcRuleList() {
        return atcRuleList;
    }

    public void setAtcRuleList(List<ATCRule> atcRuleList) {
        this.atcRuleList = atcRuleList;
    }
}
