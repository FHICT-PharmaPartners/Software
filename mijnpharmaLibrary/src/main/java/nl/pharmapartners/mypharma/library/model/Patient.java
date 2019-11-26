package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date dateOfBirth;
    private double height;
    private double weight;
    private Sex sex;
    private int creatineClearance;
    private int age;
    private boolean postMenoPause;
    private List<Medication> medicationList;
    private List<Advice> adviceList;

    public Patient() {
        //nothing
    }

    public Patient(int id, String firstName, String insertion, String lastName, String emailAddress, String password, Date dateOfBirth, double height, double weight, Sex sex, int creatineClearance, int age) {
        super(id, firstName, insertion, lastName, emailAddress, password);
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.creatineClearance = creatineClearance;
        this.age = age;
    }

    public Patient(int id, String firstName, String insertion, String lastName, String emailAddress, String password, Date dateOfBirth, double height, double weight, Sex sex, int creatineClearance) {
        super(id, firstName, insertion, lastName, emailAddress, password);
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.creatineClearance = creatineClearance;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getCreatineClearance() {
        return creatineClearance;
    }

    public void setCreatineClearance(int creatineClearance) {
        this.creatineClearance = creatineClearance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getPostMenoPause() {
        return postMenoPause;
    }

    public void setPostMenoPause(boolean postMenoPause) {
        this.postMenoPause = postMenoPause;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }
}
