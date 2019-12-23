package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
//    private Optional<User> user;
    private Date dateOfBirth;
    private double height;
    private double weight;
    private Sex sex;
    private int creatineClearance;
    private int age;
    private boolean postMenoPause;
    @OneToMany
    private List<PatientMedicine> medicineList;
    @OneToMany
    private List<Advice> adviceList;

    public Patient(int id, String firstName, String insertion, String lastName, String emailAddress, String password, Date dateOfBirth, double height, double weight, Sex sex, int creatineClearance, int age) {
        //super(id, firstName, insertion, lastName, emailAddress, password);
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.creatineClearance = creatineClearance;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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

    public boolean isPostMenoPause() {
        return postMenoPause;
    }

    public void setPostMenoPause(boolean postMenoPause) {
        this.postMenoPause = postMenoPause;
    }

    public List<PatientMedicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<PatientMedicine> medicineList) {
        this.medicineList = medicineList;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }
}
