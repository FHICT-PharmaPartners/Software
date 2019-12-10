package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.DosageRule;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DosageTest {
    private Algorithm algorithm;
    private RuleSet ruleSet;
    private Patient patient;

    //create medicine
    private List<Medication> medicationList;
    private Medication medication;
    private Medicine medicine;

    //create dosage and rule
    private List<DosageRule> dosageRules;
    private DosageRule dosageRule;
    private DosageRule secondDosageRule;

    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
        patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
                null, 170, 70, Sex.MALE, 10, 75);
        algorithm = new Algorithm();
    }

    @Test
    void testDosageFalse(){ //test anything that should return false.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5);
        dosageRule.setOperator(1);
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(10);
        medicationList.add(medication);

        boolean expected = false;
        boolean test = algorithm.checkDosage(dosageRules, medicationList);
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageMissingValue(){
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5); //set no operator to test if algorithm catches this.
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(10);
        medicationList.add(medication);

        boolean expected = false;
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerThan(){ //test one rule with '>' operator. Dosage cannot be larger than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(10);
        dosageRule.setOperator(1); // Operator: >
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(5);
        medicationList.add(medication);

        boolean expected = true;
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerThan(){ //test one rule with '<' operator. Dosage cannot be smaller than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(2);
        dosageRule.setOperator(2); // Operator: <
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(5);
        medicationList.add(medication);

        boolean expected = true;
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerOrEqualFalse(){ //test one rule with '>=' operator. Dosage is equal to or larger than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5);
        dosageRule.setOperator(3);// Operator: >=
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(6);
        medicationList.add(medication);

        boolean expected = false; //false since Dosage is equal to rule.
        boolean test = algorithm.checkDosage(dosageRules, medicationList);
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerOrEqualFalse(){ //test one rule with '<=' operator. Dosage is equal to or smaller than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5);
        dosageRule.setOperator(4); //Operator: <=
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(4);
        medicationList.add(medication);

        boolean expected = false; //false since Dosage is equal to rule.
        boolean test = algorithm.checkDosage(dosageRules, medicationList);
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerOrEqualTrue(){ //test one rule with '>=' operator. Dosage is smaller than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5);
        dosageRule.setOperator(3);// Operator: >=
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(4);
        medicationList.add(medication);

        boolean expected = true; //true since Dosage is smaller than rule.
        boolean test = algorithm.checkDosage(dosageRules, medicationList);
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerOrEqualTrue(){ //test one rule with '>=' operator. Dosage is larger than rule.
        resetDosage();
        resetMedication();

        //set Dosage rule
        dosageRule.setDosage(5);
        dosageRule.setOperator(4); //Operator: <=
        dosageRules.add(dosageRule);

        //set medicine
        medication.setDosage(6);
        medicationList.add(medication);

        boolean expected = true; //true since Dosage is larger than rule.
        boolean test = algorithm.checkDosage(dosageRules, medicationList);
        assertEquals(expected, algorithm.checkDosage(dosageRules, medicationList));
    }

    private void resetDosage(){
        dosageRules = new ArrayList<>();
        dosageRule = new DosageRule();
        secondDosageRule = new DosageRule();
    }

    private void resetMedication(){
        medicationList = new ArrayList<>();
        medicine = new Medicine();
        medication = new Medication();
    }
}
