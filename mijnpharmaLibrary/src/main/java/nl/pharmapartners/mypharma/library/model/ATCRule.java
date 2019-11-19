package nl.pharmapartners.mypharma.library.model;

public class ATCRule {
    private int id;
    private String ATCCheck;
    private int operator;

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

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
