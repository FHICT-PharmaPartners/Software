package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.bll.RuleRepository;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.dal.database.MySQLRuleContext;

public class ExecuteAlgorithm {
    private RuleRepository repo;
    private MFB mfb;
    private RuleSet ruleSet;
    private int mfbId;
    private int ruleSetId;

    public ExecuteAlgorithm() {
        this.repo = new RuleRepository(new MySQLRuleContext());
        this.mfb = null;
        this.ruleSet = null;
    }

    public MFB getMFB(int id){
        return repo.getMFB(id);
    }

    public RuleSet getRuleSet(int id){
        return null;
    }
}
