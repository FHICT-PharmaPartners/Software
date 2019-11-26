package nl.pharmapartners.mypharma.library.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Prk prk;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Prk getPrk() {
        return prk;
    }

    public void setPrk(Prk prk) {
        this.prk = prk;
    }
}


