package nl.pharmapartners.mypharma.library.model;

public class Medicine {
    private int id;
    private String name;
    private String description;
    private String atc;

    public Medicine(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Medicine() {
        //empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
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
}
