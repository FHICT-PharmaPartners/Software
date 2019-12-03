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
    private String atc;
    private String prk;

    @ManyToOne
    private Prk prk;


    public Medicine() {
        //empty constructor
    }

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

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getPrk() {
        return prk;
    }

    public void setPrk(String prk) {

        this.prk = prk;
    }
  
    public Prk getPrk() {
        return prk;
    }
  
    public Prk setPrk(Prk prk){
      this.prk = prk;
    }  
}


