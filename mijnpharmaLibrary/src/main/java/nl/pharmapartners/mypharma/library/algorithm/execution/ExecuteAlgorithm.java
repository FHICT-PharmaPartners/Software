package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.bll.RuleRepository;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.dal.database.MySQLRuleContext;

public class ExecuteAlgorithm {
    private MFB mfb;
    private RuleSet ruleSet;

    public ExecuteAlgorithm(MFB mfb, RuleSet ruleSet) {
        this.mfb = mfb;
        this.ruleSet = ruleSet;
    }
}
