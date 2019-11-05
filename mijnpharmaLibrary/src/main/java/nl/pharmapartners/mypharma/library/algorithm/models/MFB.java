package nl.pharmapartners.mypharma.library.algorithm.models;

public class MFB {
    private int id;
    private String name;
    private String ruleVersion;
    private RuleSet ruleSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRuleVersion() {
        return ruleVersion;
    }

    public MFB(int id, String name, String ruleVersion) {
        this.id = id;
        this.name = name;
        this.ruleVersion = ruleVersion;
    }
}
