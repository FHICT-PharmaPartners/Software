package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private int age;
    private Sex sex;
    private boolean postMenopauseCheck;
    private boolean isPostMenoPause;
    private int weight;
    private int creatineClearance;
    private int operator;

    public String getId() {
        return id;
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

    public boolean isPostMenopauseCheck() {
        return postMenopauseCheck;
    }

    public void setPostMenopauseCheck(boolean postMenopauseCheck) {
        this.postMenopauseCheck = postMenopauseCheck;
    }

    public boolean isPostMenoPause() {
        return isPostMenoPause;
    }

    public void setPostMenoPause(boolean postMenoPause) {
        isPostMenoPause = postMenoPause;
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
