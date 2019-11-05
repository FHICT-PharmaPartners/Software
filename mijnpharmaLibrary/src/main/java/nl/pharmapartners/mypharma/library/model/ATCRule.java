package nl.pharmapartners.mypharma.library.model;

public class ATCRule {

    private int id;
    private String ATCCheck;
    private ATC atc;

    public ATCRule(int id, String ATCCheck, ATC atc) {
        this.id = id;
        this.ATCCheck = ATCCheck;
        this.atc = atc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getATCCheck() {
        return ATCCheck;
    }

    public void setATCCheck(String ATCCheck) {
        this.ATCCheck = ATCCheck;
    }

    public ATC getAtc() {
        return atc;
    }

    public void setAtc(ATC atc) {
        this.atc = atc;
    }
}
