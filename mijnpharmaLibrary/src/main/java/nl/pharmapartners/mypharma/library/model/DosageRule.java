package nl.pharmapartners.mypharma.library.model;

public class DosageRule {
    private int id;
    private int DosageCheck;
    private int operator;

    public int getDosageCheck() {
        return DosageCheck;
    }

    public void setDosageCheck(int dosageCheck) {
        DosageCheck = dosageCheck;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
