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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return sex;
    }

    public void setGender(Sex gender) {
        this.sex = gender;
    }

    public boolean isPostMenoPause() {
        return postMenoPause;
    }

    public void setPostMenoPause(boolean postMenoPause) {
        this.postMenoPause = postMenoPause;
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
}
