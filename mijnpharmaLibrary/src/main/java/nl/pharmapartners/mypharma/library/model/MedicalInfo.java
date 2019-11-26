package nl.pharmapartners.mypharma.library.model;

import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MedicalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Date date;
    private int height;
    private double weight;
    private Sex sex;
    private int creatineClearance;
    private int age;
    private boolean postMenopause;

    @ManyToOne
    private User user;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
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

    public boolean isPostMenopause() {
        return postMenopause;
    }

    public void setPostMenopause(boolean postMenopause) {
        this.postMenopause = postMenopause;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
