package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;

public class PatientRule {
    private int id;
    private int age;
    private Sex sex;
    private boolean postMenopause;
    private int weight;
    private int creatineClearance;
    private int operator;

    public PatientRule(int id, int age, Sex sex, boolean postMenopause, int weight, int creatineClearance) {
        //set -1 as default 'empty' value
        age = -1;
        weight = -1;
        creatineClearance = -1;

        this.id = id;
        this.age = age;
        this.sex = sex;
        this.postMenopause = postMenopause;
        this.weight = weight;
        this.creatineClearance = creatineClearance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public boolean getPostMenopause() {
        return postMenopause;
    }

    public int getWeight() {
        return weight;
    }

    public int getCreatineClearance() {
        return creatineClearance;
    }

    public int getOperator() {
        return operator;
    }
}
