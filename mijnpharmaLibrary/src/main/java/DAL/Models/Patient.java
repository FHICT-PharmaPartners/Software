package DAL.Models;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date dateOfBirth;
    private int height;
    private int weight;
    private Gender gender;
    private int creatineClearance;
    private List<Medication> medicationList;
    private List<Advice> adviceList;

    public Patient(String firstName, String insertion, String lastName) {
        super(firstName, insertion, lastName);
    }

    public Patient(String firstName, String insertion, String lastName, Date dateOfBirth, int height, int weight, Gender gender) {
        super(firstName, insertion, lastName);
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCreatineClearance() {
        return creatineClearance;
    }

    public void setCreatineClearance(int creatineClearance) {
        this.creatineClearance = creatineClearance;
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

    @Override
    public String toString() {
        return "Patient{" +
                "first name=" + getFirstName() +
                ", insertion=" + getInsertion() +
                ", last name=" + getLastName() +
                ", dateOfBirth=" + dateOfBirth +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                ", creatineClearance=" + creatineClearance +
                ", medicationList=" + medicationList +
                ", adviceList=" + adviceList +
                '}';
    }
}
