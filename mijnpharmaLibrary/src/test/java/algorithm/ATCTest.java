package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.model.ATCRule;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ATCTest {
    private Algorithm algorithm;

    //create medicine
    private List<PatientMedicine> medicationList;
    private PatientMedicine patientMedicine;
    private Medicine medicine;

    //create atc and rule
    private List<ATCRule> atcRules;
    private ATCRule atcRule;
    private ATCRule secondATCRule;

    @BeforeEach
    void setUp() {
        algorithm = new Algorithm();
    }

    @Test
    void testNoATC() { //test empty rule list. Should always return true.
        resetATC();
        assertTrue(algorithm.checkATC(atcRules, medicationList));
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
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        assertTrue(algorithm.checkATC(atcRules, medicationList));
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
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        assertFalse(algorithm.checkATC(atcRules, medicationList));
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
        medicine.setMedicineAtc("src/test");
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        //should return true, no atc should match
        assertTrue(algorithm.checkATC(atcRules, medicationList));
    }

    @Test
    void testTwoATCFalse() { //test multiple ATC rules with incompatible medicine.
        resetATC();
        resetMedication();

        //set atc and rule
        String atc = "testATC";
        atcRule.setATCCheck(atc);
        medicine.setMedicineAtc(atc);
        patientMedicine.setMedicine(medicine);

        //add both to list
        atcRules.add(atcRule);
        medicationList.add(patientMedicine);

        atcRule.setATCCheck("testATC");

        //add new atc
        ATCRule atcRule1 = new ATCRule(atc);
        atcRule1.setATCCheck("test2");

        atcRules.add(atcRule1);

        //should return false, one atc should match
        assertFalse(algorithm.checkATC(atcRules, medicationList));
    }

    private void resetATC() {
        atcRules = new ArrayList<ATCRule>();
        atcRule = new ATCRule("");
        secondATCRule = new ATCRule("");
    }

    private void resetMedication() {
        medicationList = new ArrayList<PatientMedicine>();
        medicine = new Medicine();
        patientMedicine = new PatientMedicine();
    }
}
