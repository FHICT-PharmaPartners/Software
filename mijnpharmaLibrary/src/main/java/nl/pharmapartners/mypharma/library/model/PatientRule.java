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

    public PatientRule(){
        //nothing
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isPostMenopause() {
        return postMenopause;
    }

    public void setPostMenopause(boolean postMenopause) {
        this.postMenopause = postMenopause;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCreatineClearance() {
        return creatineClearance;
    }

    public void setCreatineClearance(int creatineClearance) {
        this.creatineClearance = creatineClearance;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
