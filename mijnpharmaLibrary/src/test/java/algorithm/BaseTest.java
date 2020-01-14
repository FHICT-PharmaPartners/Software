package algorithm;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {
    private Patient patient;
    private RuleSet ruleSet;

    private Algorithm algorithm;

    @BeforeEach
    void setUp() {
        patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
                null, 170, 70, Sex.MALE, 10, 75);
        ruleSet = new RuleSet();

        algorithm = new Algorithm();
    }

    @Test
    void testPatientOneMedicinePass() { // test a simulated patient with one medicine
        setPatient(patient);
        setRuleSet(ruleSet);

        boolean expected = true; // expecting pass = true
        Diagnosis actual = algorithm.run(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    @Test
    void testPatientTwoMedicinePass() { // test a simulated patient with two medicine
        setPatient(patient);
        setRuleSet(ruleSet);

        //add second medication
        patient.getMedicineList().add(setSecondMedication("ATC2", "PRK2"));

        boolean expected = true; // expecting pass = true
        Diagnosis actual = algorithm.run(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    @Test
    void testPatientTwoMedicineFail() { // test a simulated patient with two medicine
        setPatient(patient);
        setRuleSet(ruleSet);

        //add second medication
        patient.getMedicineList().add(setSecondMedication("ATCCheck", "PRK2"));

        boolean expected = false; // expecting pass = false
        Diagnosis actual = algorithm.run(ruleSet, patient);
        assertEquals(expected, actual.isPassed());
    }

    private PatientMedicine setSecondMedication(String atc, String prk) {
        Medicine secondMedicine = new Medicine();
        secondMedicine.setName("SecondTestMedicine");
        secondMedicine.setMedicineAtc(atc);
        secondMedicine.setMedicinePrk(prk);
        PatientMedicine secondPatientMedicine = new PatientMedicine();
        secondPatientMedicine.setMedicine(secondMedicine);
        secondPatientMedicine.setDosage(10);
        secondPatientMedicine.setUsageDuration(10);

        return secondPatientMedicine;
    }

    private void setPatient(Patient patient) {
        patient.setAge(50);
        patient.setCreatineClearance(10);
        patient.setHeight(170);
        patient.setPostMenoPause(false);
        patient.setSex(Sex.FEMALE);
        patient.setWeight(70);

        Medicine medicine = new Medicine();
        medicine.setMedicineAtc("ATC");
        medicine.setMedicinePrk("PRK");
        medicine.setName("TestMedicijn");

        PatientMedicine patientMedicine = new PatientMedicine();
        patientMedicine.setMedicine(medicine);
        patientMedicine.setDosage(10);
        patientMedicine.setUsageDuration(10);

        patient.setMedicineList(new ArrayList<>());
        patient.getMedicineList().add(patientMedicine);
    }

    private void setRuleSet(RuleSet ruleSet) {
        ruleSet.setATCRuleList(new ArrayList<ATCRule>());
        ruleSet.setPRKRuleList(new ArrayList<PRKRule>());
        ruleSet.setDosageRuleList(new ArrayList<DosageRule>());
        ruleSet.setDurationRuleList(new ArrayList<DurationRule>());
        ruleSet.setPatientRuleList(new ArrayList<PatientRule>());

        ATCRule atcRule = new ATCRule("ATCCheck");
        ruleSet.getATCRuleList().add(atcRule);

        PRKRule prkRule = new PRKRule("PRKCheck");
        ruleSet.getPRKRuleList().add(prkRule);

        DosageRule dosageRule = new DosageRule();
        dosageRule.setDosage(15);
        dosageRule.setOperator(1);
        dosageRule.setId("42069");
        ruleSet.getDosageRuleList().add(dosageRule);

        DurationRule durationRule = new DurationRule();
        durationRule.setDurationCheck(15);
        durationRule.setOperator(1);
        durationRule.setId("42069");
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

        ruleSet.setName("TestMFB");
        ruleSet.setMedicineId("42069");
    }
}
