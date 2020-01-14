package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.model.DosageRule;
import nl.pharmapartners.mypharma.library.model.DurationRule;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DurationTest {
    private Algorithm algorithm;

    //create medicine
    private List<PatientMedicine> medicationList;

    //create duration and rule
    private List<DurationRule> durationRules;

    @BeforeEach
    void setUp() {
        algorithm = new Algorithm();
    }

    @Test
    void testDurationFalse() { //test anything that should return false.
        durationRules = resetDuration(5, 1);
        medicationList = resetMedication(10);

        assertFalse(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationMissingValue() {
        durationRules = resetDuration(5, 0);
        medicationList = resetMedication(10);

        assertFalse(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerThan() { //test one rule with '>' operator. Duration cannot be larger than rule.
        durationRules = resetDuration(10,1);
        medicationList = resetMedication(5);

        assertTrue(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerThan() { //test one rule with '<' operator. Duration cannot be smaller than rule.
        durationRules = resetDuration(2, 2);
        medicationList = resetMedication(5);

        assertTrue(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerOrEqualFalse() { //test one rule with '>=' operator. Duration is equal to or larger than rule.
        durationRules = resetDuration(5, 3);
        medicationList = resetMedication(6);;

        assertFalse(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerOrEqualFalse() { //test one rule with '<=' operator. Duration is equal to or smaller than rule.
        durationRules = resetDuration(5, 4);
        medicationList = resetMedication(4);

        assertFalse(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerOrEqualTrue() { //test one rule with '>=' operator. Duration is smaller than rule.
        durationRules = resetDuration(5, 3);
        medicationList = resetMedication(4);

        assertTrue(algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerOrEqualTrue() { //test one rule with '>=' operator. Duration is larger than rule.
        durationRules = resetDuration(5, 4);
        medicationList = resetMedication(6);

        assertTrue(algorithm.checkDuration(durationRules, medicationList));
    }

    private List<DurationRule> resetDuration(int duration, int operator) {
        durationRules = new ArrayList<>();
        DurationRule durationRule = new DurationRule();
        durationRule.setId("420");
        durationRule.setDurationCheck(duration);
        durationRule.setOperator(operator);
        durationRules.add(durationRule);
        return durationRules;
    }

    private List<PatientMedicine> resetMedication(int duration) {
        medicationList = new ArrayList<>();
        Medicine medicine = new Medicine();
        medicine.setId("420");
        PatientMedicine patientMedicine = new PatientMedicine();
        patientMedicine.setMedicine(medicine);
        patientMedicine.setUsageDuration(duration);
        medicationList.add(patientMedicine);
        return medicationList;
    }
}
