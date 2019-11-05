package nl.pharmapartners.mypharma.library.dal.database.TestContext;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.ATCRule;
import nl.pharmapartners.mypharma.library.model.PRKRule;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.PatientRule;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;

import java.util.ArrayList;

public class TestRuleContext implements IRuleContext {
    public TestRuleContext() {

    }

    public MFB getMFB(int id){
        return new MFB(id, "test", "vTest");
    }

    public RuleSet getRuleSet(int id) {
        RuleSet ruleSet = new RuleSet(new ArrayList<PatientRule>(), new ArrayList<PRKRule>(), new ArrayList<ATCRule>());
        ruleSet.setMFBId(1);
        return ruleSet;
    }
}
