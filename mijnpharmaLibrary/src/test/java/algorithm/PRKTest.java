package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.PRKRule;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PRKTest {
    private Algorithm algorithm;
//    private RuleSet ruleSet;
//    private Patient patient;

    //create medicine
    private List<PatientMedicine> medicationList;
    private PatientMedicine patientMedicine;
    private Medicine medicine;

    //create prk and rule
    private List<PRKRule> prkRules;
    private PRKRule prkRule;
    private PRKRule secondPRKRule;

    @BeforeEach
    void setUp() {
//        ruleSet = new RuleSet();
//        patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
//                null, 170, 70, Sex.MALE, 10, 75);
        algorithm = new Algorithm();
    }

    @Test
    void testNoPRK() { //test empty rule list. Should always return true.
        resetPRK();
        resetMedication();

        boolean expected = true;
        assertEquals(expected, algorithm.checkPRK(prkRules, medicationList));
    }

    @Test
    void testOnePRKTrue() { //test one PRK rule and compatible medicine.
        resetPRK();
        resetMedication();

        //set PRK rules
        prkRule.setPRKCheck("testTrue");
        prkRules.add(prkRule);

        //set medicine
        medicine.setMedicinePrk("testMedicine");
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        boolean expected = true;
        assertEquals(expected, algorithm.checkPRK(prkRules, medicationList));
    }

    @Test
    void testOnePRKFalse() { //test one PRK rule and incompatible medicine
        resetPRK();
        resetMedication();

        //set PRK rules
        prkRule.setPRKCheck("testFalse");
        prkRules.add(prkRule);

        //set medicine
        medicine.setMedicinePrk("testFalse");
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        boolean expected = false;
        assertEquals(expected, algorithm.checkPRK(prkRules, medicationList));
    }

    @Test
    void testTwoPRKTrue() { //test multiple PRK rules with compatible medicine
        resetPRK();
        resetMedication();

        //set PRK rules
        prkRule.setPRKCheck("testTrue");
        prkRules.add(prkRule);
        secondPRKRule.setPRKCheck("testTrue2");
        prkRules.add(secondPRKRule);

        //set medicine
        medicine.setMedicinePrk("test");
        patientMedicine.setMedicine(medicine);
        medicationList.add(patientMedicine);

        //should return true, no PRK should match
        boolean expected = true;
        assertEquals(expected, algorithm.checkPRK(prkRules, medicationList));
    }

    @Test
    void testTwoPRKFalse() { //test multiple PRK rules with incompatible medicine.
        resetPRK();
        resetMedication();

        //set PRK and rule
        String prk = "testPRK";
        prkRule.setPRKCheck(prk);
        medicine.setMedicinePrk(prk);
        patientMedicine.setMedicine(medicine);

        //add both to list
        prkRules.add(prkRule);
        medicationList.add(patientMedicine);

        prkRule.setPRKCheck("testPRK");

        //add new PRK
        PRKRule prkRule1 = new PRKRule("");
        prkRule1.setPRKCheck("test2");

        prkRules.add(prkRule1);

        //should return false, one PRK should match
        boolean expected = false;
        assertEquals(expected, algorithm.checkPRK(prkRules, medicationList));
    }

    private void resetPRK() {
        prkRules = new ArrayList<>();
        prkRule = new PRKRule("");
        secondPRKRule = new PRKRule("");
    }

    private void resetMedication() {
        medicationList = new ArrayList<>();
        medicine = new Medicine();
        patientMedicine = new PatientMedicine();
    }
}
