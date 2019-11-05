package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.dal.database.MySQLRuleContext;
import nl.pharmapartners.mypharma.library.dal.database.TestContext.TestRuleContext;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;

public class RuleRepository{
    private IRuleContext context;

    public RuleRepository(MySQLRuleContext ruleContext) {
        this.context = new MySQLRuleContext();
    }

    public RuleRepository(){
        this.context = new TestRuleContext();
    }

    public MFB getMFB(int id){
        return context.getMFB(id);
    }

    public RuleSet getRuleSet(int id) {return context.getRuleSet(id);}
}
