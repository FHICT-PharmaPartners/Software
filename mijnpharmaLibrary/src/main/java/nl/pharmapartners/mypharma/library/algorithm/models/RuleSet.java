package nl.pharmapartners.mypharma.library.algorithm.models;

import nl.pharmapartners.mypharma.library.model.*;

import java.util.List;

public class RuleSet {
    private int MFBId;
    private MFB mfb;
    private Patient patient;
    private List<PatientRule> patientRuleList;
    private List<PRKRule> PRKRuleList;
    private List<DosageRule> dosageRuleList;
    private List<DurationRule> durationRuleList;
    private List<ATCRule> ATCRuleList;

    public RuleSet() {
        //empty constructor
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

    public List<PRKRule> getPRKRuleList() {
        return PRKRuleList;
    }

    public void setPRKRuleList(List<PRKRule> PRKRuleList) {
        this.PRKRuleList = PRKRuleList;
    }

    public List<DosageRule> getDosageRuleList() {
        return dosageRuleList;
    }

    public void setDosageRuleList(List<DosageRule> dosageRuleList) {
        this.dosageRuleList = dosageRuleList;
    }

    public List<DurationRule> getDurationRuleList() {
        return durationRuleList;
    }

    public void setDurationRuleList(List<DurationRule> durationRuleList) {
        this.durationRuleList = durationRuleList;
    }

    public List<ATCRule> getATCRuleList() {
        return ATCRuleList;
    }

    public void setATCRuleList(List<ATCRule> ATCRuleList) {
        this.ATCRuleList = ATCRuleList;
    }

    public int getMFBId() {
        return MFBId;
    }

    public void setMFBId(int MFBId) {
        this.MFBId = MFBId;
    }

    public MFB getMfb() {
        return mfb;
    }

    public void setMfb(MFB mfb) {
        this.mfb = mfb;
    }
}
