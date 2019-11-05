package nl.pharmapartners.mypharma.library.dal.database.TestContext;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;

public class TestSQLRuleContext implements IRuleContext {
    public TestSQLRuleContext() {

    }

    public MFB getMFB(int id){
        return new MFB(id, "test", "vTest");
    }
}
