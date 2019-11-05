package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.dal.database.MySQLRuleContext;

public class ExecuteAlgorithm {
    private MySQLRuleContext context;
    private MFB mfb;
    private RuleSet ruleSet;
    private int mfbId;
    private int ruleSetId;

    public ExecuteAlgorithm(MySQLRuleContext context) {
        this.context = context;
        this.mfb = null;
        this.ruleSet = null;
    }

    /**
     * Main method only for testing purposes; should be removed once finished.
     * @param args
     */
//    public static void main(String args[]){
//        ExecuteAlgorithm test = new ExecuteAlgorithm(new MySQLRuleContext(new MySQLContext()));
//        MFB mfb = test.getMFB(1);
//        System.out.println(mfb.getName());
//    }

    public MFB getMFB(int id){
        return context.getMFB(id);
    }
}
