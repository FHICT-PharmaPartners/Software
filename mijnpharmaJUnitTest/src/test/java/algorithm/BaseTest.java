package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseTest {
    private List<ATCRule> atcRules;
    private List<DosageRule> dosageRules;
    private List<DurationRule> durationRules;
    private List<PatientRule> patientRules;
    private List<PRKRule> prkRules;

    private Patient patient;
    private RuleSet ruleSet;

    private Algorithm algorithm;

    @BeforeEach
    void setUp() {
        atcRules = new ArrayList<ATCRule>();
        dosageRules = new ArrayList<DosageRule>();
        durationRules = new ArrayList<DurationRule>();
        patientRules = new ArrayList<PatientRule>();
        prkRules = new ArrayList<PRKRule>();

        patient = new Patient();
        ruleSet = new RuleSet();

        algorithm = new Algorithm();
    }

    @Test
    void testPatientOneMedicinePass() { // test a simulated patient with one medicine
        patient = setPatient(patient);
        ruleSet = setRuleSet(ruleSet);

        boolean expected = true; // expecting pass = true
        Diagnosis actual = algorithm.executeAlgorithm(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    @Test
    void testPatientTwoMedicinePass() { // test a simulated patient with two medicine
        patient = setPatient(patient);
        ruleSet = setRuleSet(ruleSet);

        //add second medication
        Medicine secondMedicine = new Medicine();
        secondMedicine.setAtc("ATC2");
        secondMedicine.setPrk("PRK2");
        Medication secondMedication = new Medication(secondMedicine, 10, 10);
        patient.getMedicationList().add(secondMedication);

        boolean expected = true; // expecting pass = true
        Diagnosis actual = algorithm.executeAlgorithm(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    @Test
    void testPatientTwoMedicineFail() { // test a simulated patient with two medicine
        patient = setPatient(patient);
        ruleSet = setRuleSet(ruleSet);

        //add second medication
        Medicine secondMedicine = new Medicine();
        secondMedicine.setName("SecondTestMedicine");
        secondMedicine.setAtc("ATCCheck");
        secondMedicine.setPrk("PRK2");
        Medication secondMedication = new Medication(secondMedicine, 10, 10);
        patient.getMedicationList().add(secondMedication);

        boolean expected = false; // expecting pass = false
        Diagnosis actual = algorithm.executeAlgorithm(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    private Patient setPatient(Patient patient) {
        patient.setAge(50);
        patient.setCreatineClearance(10);
        patient.setHeight(170);
        patient.setPostMenoPause(false);
        patient.setSex(Sex.FEMALE);
        patient.setWeight(70);

        Medicine medicine = new Medicine();
        medicine.setAtc("ATC");
        medicine.setPrk("PRK");
        medicine.setName("TestMedicijn");

        Medication medication = new Medication(medicine, 10, 10);

        patient.setMedicationList(new ArrayList<Medication>());
        patient.getMedicationList().add(medication);

        return patient;
    }

    private RuleSet setRuleSet(RuleSet ruleSet) {
        ruleSet.setATCRuleList(new ArrayList<ATCRule>());
        ruleSet.setPRKRuleList(new ArrayList<PRKRule>());
        ruleSet.setDosageRuleList(new ArrayList<DosageRule>());
        ruleSet.setDurationRuleList(new ArrayList<DurationRule>());
        ruleSet.setPatientRuleList(new ArrayList<PatientRule>());

        ATCRule atcRule = new ATCRule("ATCCheck");
        ruleSet.getATCRuleList().add(atcRule);

        PRKRule prkRule = new PRKRule("PRKCheck");
        ruleSet.getPRKRuleList().add(prkRule);

        DosageRule dosageRule = new DosageRule(12, 1);
        ruleSet.getDosageRuleList().add(dosageRule);

        DurationRule durationRule = new DurationRule(12, 1);
        ruleSet.getDurationRuleList().add(durationRule);

        PatientRule patientRuleAge = new PatientRule();
        PatientRule patientRuleCreatine = new PatientRule();
        PatientRule patientRuleMeno = new PatientRule();
        PatientRule patientRuleWeight = new PatientRule();

        patientRuleAge.setAge(80);
        patientRuleAge.setOperator(1);

        patientRuleCreatine.setCreatineClearance(12);
        patientRuleCreatine.setOperator(1);

        patientRuleMeno.setPostMenopauseCheck(true);
        patientRuleMeno.setPostMenoPause(false);

        patientRuleWeight.setWeight(100);
        patientRuleWeight.setOperator(1);

        ruleSet.getPatientRuleList().add(patientRuleAge);
        ruleSet.getPatientRuleList().add(patientRuleCreatine);
        ruleSet.getPatientRuleList().add(patientRuleMeno);
        ruleSet.getPatientRuleList().add(patientRuleWeight);

        MFB mfb = new MFB(1, "TestMFB", "T-1");
        ruleSet.setMfb(mfb);

        return ruleSet;
    }
}
