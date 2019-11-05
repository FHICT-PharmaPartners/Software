package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.dal.database.MySQLRuleContext;
import nl.pharmapartners.mypharma.library.dal.database.TestContext.TestSQLRuleContext;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;

public class RuleRepository{
    private IRuleContext context;

    public RuleRepository(MySQLRuleContext ruleContext) {
        this.context = new MySQLRuleContext();
    }

    public RuleRepository(){
        this.context = new TestSQLRuleContext();
    }

    public MFB getMFB(int id){
        return context.getMFB(id);
    }
}
