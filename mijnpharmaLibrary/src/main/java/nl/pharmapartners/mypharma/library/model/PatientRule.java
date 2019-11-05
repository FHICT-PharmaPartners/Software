package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;

public class PatientRule {
    private int id;
    private int age;
    private Sex sex;
    private boolean postMenoPause;
    private int weight;
    private int creatineClearance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientRule(int id, int age, Sex sex, boolean postMenoPause, int weight, int creatineClearance) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.postMenoPause = postMenoPause;
        this.weight = weight;
        this.creatineClearance = creatineClearance;
    }
}
