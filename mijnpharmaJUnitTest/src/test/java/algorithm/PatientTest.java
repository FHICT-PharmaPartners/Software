package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PatientTest {
    private Algorithm algorithm;
    private RuleSet ruleSet;
    private Patient patient;

    //create medicine
    private List<Medication> medicationList;
    private Medication medication;
    private Medicine medicine;

    //create patient and rule
    private List<PatientRule> patientRules;
    private PatientRule patientRule;
    private PatientRule secondPatientRule;

    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
        patient = new Patient();
        algorithm = new Algorithm();
    }

    @Test
    void testAgeLarger(){
        resetPatient();
        resetRule();

        //set age
        patient.setAge(75);

        //set rule
        patientRule.setAge(70);
        patientRule.setOperator(1);
        patientRules.add(patientRule);

        boolean expected = false;
        assertEquals(expected, algorithm.checkPatient(patientRules, patient));
    }

    @Test
    void testAgeSmaller(){
        resetPatient();
        resetRule();

        //set age
        patient.setAge(75);

        //set rule
        patientRule.setAge(70);
        patientRule.setOperator(2);
        patientRules.add(patientRule);

        boolean expected = true;
        assertEquals(expected, algorithm.checkPatient(patientRules, patient));
    }

    @Test
    void testWeightLarger(){
        resetPatient();
        resetRule();

        //set age
        patient.setWeight(75);

        //set rule
        patientRule.setWeight(70);
        patientRule.setOperator(1);
        patientRules.add(patientRule);

        boolean expected = false;
        assertEquals(expected, algorithm.checkPatient(patientRules, patient));
    }

    @Test
    void testWeightSmaller(){
        resetPatient();
        resetRule();

        //set age
        patient.setWeight(75);

        //set rule
        patientRule.setWeight(70);
        patientRule.setOperator(2);
        patientRules.add(patientRule);

        boolean expected = true;
        boolean actual = algorithm.checkPatient(patientRules, patient);
        assertEquals(expected, actual);
    }

    @Test
    void testMenoPauseFalse(){
        resetPatient();
        resetRule();

        //set patient
        patient.setPostMenoPause(false);
        patient.setSex(Sex.FEMALE);

        //set rule
        patientRule.setPostMenopauseCheck(true);
        patientRule.setPostMenoPause(false);
        patientRule.setSex(Sex.FEMALE);
        patientRules.add(patientRule);

        boolean expected = true;
        boolean actual = algorithm.checkPatient(patientRules, patient);
        assertEquals(expected, algorithm.checkPatient(patientRules, patient));
    }

    @Test
    void testMenoPauseTrue(){
        resetPatient();
        resetRule();

        //set patient
        patient.setPostMenoPause(true);

        //set rule
        patientRule.setPostMenopauseCheck(true);
        patientRule.setPostMenoPause(true);
        patientRules.add(patientRule);

        boolean expected = true;
        boolean actual = algorithm.checkPatient(patientRules, patient);
        assertEquals(expected, algorithm.checkPatient(patientRules, patient));
    }

    private void resetPatient(){
        patient = new Patient();
    }

    private void resetRule(){
        patientRules = new ArrayList<PatientRule>();
        patientRule = new PatientRule();
        secondPatientRule = new PatientRule();
    }
}
