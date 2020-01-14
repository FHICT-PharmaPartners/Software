package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.model.DosageRule;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DosageTest {
    private Algorithm algorithm;

    //create medicine
    private List<PatientMedicine> medicationList;

    //create dosage and rule
    private List<DosageRule> dosageRules;

    @BeforeEach
    void setUp() {
        algorithm = new Algorithm();
    }

    @Test
    void testDosageFalse() { //test anything that should return false.
        dosageRules = resetDosage(5, 1);
        medicationList = resetMedication(10);

        assertFalse(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageMissingValue() {
        dosageRules = resetDosage(5, 0);
        medicationList = resetMedication(10);
        assertFalse(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerThan() { //test one rule with '>' operator. Dosage cannot be larger than rule.
        dosageRules = resetDosage(10, 1);
        medicationList = resetMedication(5);

        assertTrue(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerThan() { //test one rule with '<' operator. Dosage cannot be smaller than rule.
        dosageRules = resetDosage(2, 2);
        medicationList = resetMedication(5);

        assertTrue(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerOrEqualFalse() { //test one rule with '>=' operator. Dosage is equal to or larger than rule.
        dosageRules = resetDosage(5, 3);
        medicationList = resetMedication(6);

        assertFalse(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerOrEqualFalse() { //test one rule with '<=' operator. Dosage is equal to or smaller than rule.
        dosageRules = resetDosage(5, 4);
        medicationList = resetMedication(4);

        assertFalse(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageLargerOrEqualTrue() { //test one rule with '>=' operator. Dosage is smaller than rule.
        dosageRules = resetDosage(5, 3);
        medicationList = resetMedication(4);

        assertTrue(algorithm.checkDosage(dosageRules, medicationList));
    }

    @Test
    void testDosageSmallerOrEqualTrue() { //test one rule with '>=' operator. Dosage is larger than rule.
        dosageRules = resetDosage(5, 4);
        medicationList = resetMedication(6);

        assertTrue(algorithm.checkDosage(dosageRules, medicationList));
    }

    private List<DosageRule> resetDosage(int dosage, int operator) {
        dosageRules = new ArrayList<>();
        DosageRule dosageRule = new DosageRule();
        dosageRule.setId("420");
        dosageRule.setDosage(dosage);
        dosageRule.setOperator(operator);
        dosageRules.add(dosageRule);
        return dosageRules;
    }

    private List<PatientMedicine> resetMedication(int dosage) {
        medicationList = new ArrayList<>();
        Medicine medicine = new Medicine();
        medicine.setId("420");
        PatientMedicine patientMedicine = new PatientMedicine();
        patientMedicine.setMedicine(medicine);
        patientMedicine.setDosage(dosage);
        medicationList.add(patientMedicine);
        return medicationList;
    }
}
