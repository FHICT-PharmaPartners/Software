package nl.pharmapartners.mypharma.library.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsageRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private int usageDuration;

    public String getId() {
        return id;
    }

    public int getUsageDuration() {
        return usageDuration;
    }

    public void setUsageDuration(int usageDuration) {
        this.usageDuration = usageDuration;
    }
}
