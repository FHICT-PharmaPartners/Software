package nl.pharmapartners.mypharma.library.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PRKRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String PRKCheck;
    private int operator;

    public PRKRule(String PRKCheck) {
        this.PRKCheck = PRKCheck;
    }

    public PRKRule() {
    }

    public String getId() {
        return id;
    }

    public String getPRKCheck() {
        return PRKCheck;
    }

    public void setPRKCheck(String PRKCheck) {
        this.PRKCheck = PRKCheck;
    }
}
