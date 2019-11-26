package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
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
        algorithm = new Algorithm(ruleSet, patient);
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

    private void resetPatient(){
        patient = new Patient();
    }

    private void resetRule(){
        patientRules = new ArrayList<PatientRule>();
        patientRule = new PatientRule();
        secondPatientRule = new PatientRule();
    }
}
