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
    private String medicineAtc;
    private String medicinePrk;

    @ManyToOne
    private Prk prk;

    @ManyToOne
    private Atc atc;

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

    public String getMedicineAtc() {
        return medicineAtc;
    }

    public void setMedicineAtc(String atc) {
        this.medicineAtc = atc;
    }

    public String getMedicinePrk() {
        return medicinePrk;
    }

    public void setMedicinePrk(String prk) {

        this.medicinePrk = prk;
    }
  
    public Prk getPrk() {
        return prk;
    }
  
    public void setPrk(Prk prk){
      this.prk = prk;
    }  

    public Atc getAtc() {
        return atc;
    }

    public void setAtc(Atc atc) {
        this.atc = atc;
    }

    public void setId(String id) {
        this.id = id;
    }
}


