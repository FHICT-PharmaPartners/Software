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

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(String ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public MFB(int id, String name, String ruleVersion) {
        this.id = id;
        this.name = name;
        this.ruleVersion = ruleVersion;
    }
}
