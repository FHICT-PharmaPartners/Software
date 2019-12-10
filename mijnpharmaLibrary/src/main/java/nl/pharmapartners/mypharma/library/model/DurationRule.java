package nl.pharmapartners.mypharma.library.model;

public class DurationRule {
    private int id;
    private int DurationCheck;
    private int operator;

    public DurationRule(int durationCheck, int operator) {
        DurationCheck = durationCheck;
        this.operator = operator;
    }

    public int getDurationCheck() {
        return DurationCheck;
    }

    public void setDurationCheck(int durationCheck) {
        DurationCheck = durationCheck;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
