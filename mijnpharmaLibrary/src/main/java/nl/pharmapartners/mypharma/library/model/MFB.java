package nl.pharmapartners.mypharma.library.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class MFB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;

    @ManyToOne
    private ATCRule atcRule;

    @ManyToOne
    private DosageRule dosageRule;

    @ManyToOne
    private PatientRule patientRule;

    @ManyToOne
    private PRKRule prkRule;

    @ManyToOne
    private UsageRule usageRule;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ATCRule getAtcRule() {
        return atcRule;
    }

    public void setAtcRule(ATCRule atcRule) {
        this.atcRule = atcRule;
    }

    public DosageRule getDosageRule() {
        return dosageRule;
    }

    public void setDosageRule(DosageRule dosageRule) {
        this.dosageRule = dosageRule;
    }

    public PatientRule getPatientRule() {
        return patientRule;
    }

    public void setPatientRule(PatientRule patientRule) {
        this.patientRule = patientRule;
    }

    public PRKRule getPrkRule() {
        return prkRule;
    }

    public void setPrkRule(PRKRule prkRule) {
        this.prkRule = prkRule;
    }

    public UsageRule getUsageRule() {
        return usageRule;
    }

    public void setUsageRule(UsageRule usageRule) {
        this.usageRule = usageRule;
    }
}
