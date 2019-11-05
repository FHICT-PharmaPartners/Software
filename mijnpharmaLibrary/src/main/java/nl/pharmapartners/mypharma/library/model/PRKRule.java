package nl.pharmapartners.mypharma.library.model;

public class PRKRule {
    private int id;
    private String PRKCheck;
    private PRK prk;

    public PRKRule(int id, String PRKCheck, PRK prk) {
        this.id = id;
        this.PRKCheck = PRKCheck;
        this.prk = prk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPRKCheck() {
        return PRKCheck;
    }

    public void setPRKCheck(String PRKCheck) {
        this.PRKCheck = PRKCheck;
    }

    public PRK getPrk() {
        return prk;
    }

    public void setPrk(PRK prk) {
        this.prk = prk;
    }
}
