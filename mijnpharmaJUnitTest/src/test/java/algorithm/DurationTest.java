package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.DurationRule;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DurationTest {
    private Algorithm algorithm;
    private RuleSet ruleSet;
    private Patient patient;

    //create medicine
    private List<Medication> medicationList;
    private Medication medication;
    private Medicine medicine;

    //create duration and rule
    private List<DurationRule> durationRules;
    private DurationRule durationRule;
    private DurationRule secondDurationRule;

    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
        patient = new Patient();
        algorithm = new Algorithm(ruleSet, patient);
    }

    @Test
    void testDurationFalse(){ //test anything that should return false.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5);
        durationRule.setOperator(1);
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(10);
        medicationList.add(medication);

        boolean expected = false;
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationMissingValue(){
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5); //set no operator to test if algorithm catches this.
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(10);
        medicationList.add(medication);

        boolean expected = false;
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerThan(){ //test one rule with '>' operator. Duration cannot be larger than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(10);
        durationRule.setOperator(1); // Operator: >
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(5);
        medicationList.add(medication);

        boolean expected = true;
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerThan(){ //test one rule with '<' operator. Duration cannot be smaller than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(2);
        durationRule.setOperator(2); // Operator: <
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(5);
        medicationList.add(medication);

        boolean expected = true;
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerOrEqualFalse(){ //test one rule with '>=' operator. Duration is equal to or larger than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5);
        durationRule.setOperator(3);// Operator: >=
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(6);
        medicationList.add(medication);

        boolean expected = false; //false since duration is equal to rule.
        boolean test = algorithm.checkDuration(durationRules, medicationList);
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerOrEqualFalse(){ //test one rule with '<=' operator. Duration is equal to or smaller than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5);
        durationRule.setOperator(4); //Operator: <=
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(4);
        medicationList.add(medication);

        boolean expected = false; //false since duration is equal to rule.
        boolean test = algorithm.checkDuration(durationRules, medicationList);
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationLargerOrEqualTrue(){ //test one rule with '>=' operator. Duration is smaller than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5);
        durationRule.setOperator(3);// Operator: >=
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(4);
        medicationList.add(medication);

        boolean expected = true; //true since duration is smaller than rule.
        boolean test = algorithm.checkDuration(durationRules, medicationList);
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    @Test
    void testDurationSmallerOrEqualTrue(){ //test one rule with '>=' operator. Duration is larger than rule.
        resetDuration();
        resetMedication();

        //set duration rule
        durationRule.setDurationCheck(5);
        durationRule.setOperator(4); //Operator: <=
        durationRules.add(durationRule);

        //set medicine
        medication.setDuration(6);
        medicationList.add(medication);

        boolean expected = true; //true since duration is larger than rule.
        boolean test = algorithm.checkDuration(durationRules, medicationList);
        assertEquals(expected, algorithm.checkDuration(durationRules, medicationList));
    }

    private void resetDuration(){
        durationRules = new ArrayList<DurationRule>();
        durationRule = new DurationRule();
        secondDurationRule = new DurationRule();
    }

    private void resetMedication(){
        medicationList = new ArrayList<Medication>();
        medicine = new Medicine();
        medication = new Medication();
    }
}
