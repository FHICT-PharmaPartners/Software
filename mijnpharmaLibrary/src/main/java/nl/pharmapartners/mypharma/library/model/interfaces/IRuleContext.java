package nl.pharmapartners.mypharma.library.model.interfaces;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.model.RuleSet;

public interface IRuleContext {
    MFB getMFB(int id);

    RuleSet getRuleSet(int id);
}
