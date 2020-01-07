package nl.pharmapartners.mypharma.library.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ATCRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String ATCCheck;
    private int operator;

    public ATCRule(String ATCCheck) {
        this.ATCCheck = ATCCheck;
    }

    public ATCRule() {
    }

    public String getId() {
        return id;
    }

    public String getATCCheck() {
        return ATCCheck;
    }

    public void setATCCheck(String ATCCheck) {
        this.ATCCheck = ATCCheck;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
