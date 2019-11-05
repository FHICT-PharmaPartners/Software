package Repositories;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.bll.RuleRepository;
import nl.pharmapartners.mypharma.library.dal.database.TestContext.TestSQLRuleContext;
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

    @AfterEach
    void tearDown(){

    }

    @Test
    void getMFB(){
        int id = 1;
        MFB mfb = repo.getMFB(id);
        assertEquals(id, mfb.getId());
    }
}
