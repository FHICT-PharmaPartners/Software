package Repositories;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.bll.RuleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class RuleRepositoryTest {
    private RuleRepository repo;

    @BeforeEach
    void setup(){
        repo = new RuleRepository();
    }

//    @AfterEach
//    void tearDown(){
//    }

    @Test
    void getMFB(){
        int id = 1;
        MFB mfb = repo.getMFB(id);
        assertEquals(id, mfb.getId());
    }

    @Test
    void getRuleSet(){
        int id = 1;
        RuleSet ruleSet = repo.getRuleSet(id);
        assertEquals(id, ruleSet.getMFBId());
    }
}
