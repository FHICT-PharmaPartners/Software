package nl.pharmapartners.mypharma.library.algorithm.models;

import nl.pharmapartners.mypharma.library.model.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class RuleSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String medicineId;
    private String name;
    @OneToMany
    private List<PatientRule> patientRuleList;
    @OneToMany
    private List<PRKRule> PRKRuleList;
    @OneToMany
    private List<DosageRule> dosageRuleList;
    @OneToMany
    private List<DurationRule> durationRuleList;
    @OneToMany
    private List<ATCRule> ATCRuleList;

    public RuleSet() {
        //empty constructor
    }

    public RuleSet(List<PatientRule> patientRuleList, List<PRKRule> PRKRuleList, List<ATCRule> ATCRuleList) {
        this.patientRuleList = patientRuleList;
        this.PRKRuleList = PRKRuleList;
        this.ATCRuleList = ATCRuleList;
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

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
