package nl.pharmapartners.mypharma.library.model;

public class PRKRule {
    private int id;
    private String PRKCheck;
    private int operator;

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
}
