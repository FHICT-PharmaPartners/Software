package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.ATCRule;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlgorithmTest {
    private Algorithm algorithm;
    private RuleSet ruleSet;
    private Patient patient;

    //create atc and rule
    private List<ATCRule> atcRules;
    private List<Medication> medicationList;
    private ATCRule atcRule;
    private Medication medication;
    private Medicine medicine;
    private String atc = "testATC";


    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
        patient = new Patient();
        algorithm = new Algorithm(ruleSet, patient);
    }

    @Test
    void testOneATC() { //test one atc and one medicine
        setupATC();
        boolean expected = false;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testTwoATC(){ //test multiple atc with one medicine
        setupATC();

        //add new atc
        ATCRule atcRule1 = new ATCRule();
        atcRule.setATCCheck("test");
        atcRule1.setATCCheck("test2");
        atcRules.add(atcRule1);

        //should return true, no atc should match
        boolean expected = true;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    private void setupATC() {
        atcRules = new ArrayList<ATCRule>();
        medicationList = new ArrayList<Medication>();
        atcRule = new ATCRule();
        medication = new Medication();
        medicine = new Medicine();

        //set atc and rule
        atcRule.setATCCheck(atc);
        medicine.setAtc(atc);
        medication.setMedicine(medicine);

        //add both to list
        atcRules.add(atcRule);
        medicationList.add(medication);
    }
}
