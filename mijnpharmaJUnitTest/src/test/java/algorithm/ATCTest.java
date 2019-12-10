package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ATCTest {
    private Algorithm algorithm;
    private RuleSet ruleSet;
    private Patient patient;

    //create medicine
    private List<Medication> medicationList;
    private Medication medication;
    private Medicine medicine;

    //create atc and rule
    private List<ATCRule> atcRules;
    private ATCRule atcRule;
    private ATCRule secondATCRule;

    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
        patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
                null, 170, 70, Sex.MALE, 10, 75);
        algorithm = new Algorithm();
    }

    @Test
    void testNoATC() { //test empty rule list. Should always return true.
        resetATC();

        boolean expected = true;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testOneATCTrue() { //test one ATC rule and compatible medicine.
        resetATC();
        resetMedication();

        //set ATC rules
        atcRule.setATCCheck("testTrue");
        atcRules.add(atcRule);

        //set medicine
        medicine.setMedicineAtc("testMedicine");
        medication.setMedicine(medicine);
        medicationList.add(medication);

        boolean expected = true;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testOneATCFalse() { //test one ATC rule and incompatible medicine
        resetATC();
        resetMedication();

        //set ATC rules
        atcRule.setATCCheck("testFalse");
        atcRules.add(atcRule);

        //set medicine
        medicine.setMedicineAtc("testFalse");
        medication.setMedicine(medicine);
        medicationList.add(medication);

        boolean expected = false;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testTwoATCTrue() { //test multiple ATC rules with compatible medicine
        resetATC();
        resetMedication();

        //set ATC rules
        atcRule.setATCCheck("testTrue");
        atcRules.add(atcRule);
        secondATCRule.setATCCheck("testTrue2");
        atcRules.add(secondATCRule);

        //set medicine
        medicine.setMedicineAtc("test");
        medication.setMedicine(medicine);
        medicationList.add(medication);

        //should return true, no atc should match
        boolean expected = true;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testTwoATCFalse() { //test multiple ATC rules with incompatible medicine.
        resetATC();
        resetMedication();

        //set atc and rule
        String atc = "testATC";
        atcRule.setATCCheck(atc);
        medicine.setMedicineAtc(atc);
        medication.setMedicine(medicine);

        //add both to list
        atcRules.add(atcRule);
        medicationList.add(medication);

        atcRule.setATCCheck("testATC");

        //add new atc
        ATCRule atcRule1 = new ATCRule(atc);
        atcRule1.setATCCheck("test2");

        atcRules.add(atcRule1);

        //should return false, one atc should match
        boolean expected = false;
        assertEquals(expected, algorithm.checkATC(atcRules, medicationList));
    }

    private void resetATC() {
        atcRules = new ArrayList<ATCRule>();
        atcRule = new ATCRule("");
        secondATCRule = new ATCRule("");
    }

    private void resetMedication() {
        medicationList = new ArrayList<Medication>();
        medicine = new Medicine();
        medication = new Medication(medicine, 0, 0);
    }
}
