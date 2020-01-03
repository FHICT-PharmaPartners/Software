package Executor;

import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.model.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExecutorTest {
    private Patient patient;
    private Executor executor;
    private Diagnosis diagnosis;
    private List<RuleSet> ruleSets = new ArrayList<>();

    @BeforeEach
    void setUp() {
        ruleSets.add(setRuleSet());
        ruleSets.add(setSecondRuleSet());
        setMedicine();
    }

    @Test
    void testCheckAll() {
        executor = new Executor(ruleSets, patient);
        diagnosis = executor.generateDiagnosis();

        assertTrue(diagnosis.isPassed());
    }

    @Test
    void testMultipleMedicine() {
        setSecondMedicine();
        executor = new Executor(ruleSets, patient);
        diagnosis = executor.generateDiagnosis();

        assertTrue(diagnosis.isPassed());
    }

    @Test
    void testMultipleMedicineFail() {
        setThirdMedicine();
        executor = new Executor(ruleSets, patient);
        diagnosis = executor.generateDiagnosis();

        assertFalse(diagnosis.isPassed());
    }

    private void setMedicine() {
        patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
                null, 170, 70, Sex.MALE, 10, 72);
        Medicine medicine = new Medicine();
        PatientMedicine patientMedicine = new PatientMedicine();

        //set medicine
        medicine.setMedicineAtc("testMedicine");
        medicine.setId("69");
        patientMedicine.setMedicine(medicine);
        patient.setMedicineList(new ArrayList<>());
        patient.getMedicineList().add(patientMedicine);
    }

    private void setSecondMedicine() {
        Medicine medicine = new Medicine();
        PatientMedicine patientMedicine = new PatientMedicine();

        //set medicine
        medicine.setMedicineAtc("testMedicine2");
        medicine.setId("420");
        medicine.setName("TestPil");
        patientMedicine.setMedicine(medicine);
        patientMedicine.setDosage(2);
        patient.getMedicineList().add(patientMedicine);
    }

    private void setThirdMedicine() {
        Medicine medicine = new Medicine();
        PatientMedicine patientMedicine = new PatientMedicine();

        //set medicine
        medicine.setMedicineAtc("testMedicine2");
        medicine.setId("420");
        medicine.setName("TestPil");
        patientMedicine.setMedicine(medicine);
        patientMedicine.setDosage(10);
        patient.getMedicineList().add(patientMedicine);
    }

    private RuleSet setRuleSet() {
        RuleSet ruleSet = new RuleSet();
        ruleSet.setATCRuleList(new ArrayList<>());
        ruleSet.setDosageRuleList(new ArrayList<>());
        ruleSet.setDurationRuleList(new ArrayList<>());
        ruleSet.setPRKRuleList(new ArrayList<>());
        List<PatientRule> patientRules = new ArrayList<>();
        List<DosageRule> dosageRules = new ArrayList<>();
        PatientRule patientRule = new PatientRule();
        PatientRule patientRule2 = new PatientRule();
        DosageRule dosageRule = new DosageRule();

        patientRule.setAge(75);
        patientRule.setOperator(1);

        dosageRule.setDosage(5);
        dosageRule.setOperator(1);
        dosageRules.add(dosageRule);

        patientRule2.setWeight(80);
        patientRule2.setOperator(1);

        patientRules.add(patientRule);
        patientRules.add(patientRule2);

        ruleSet.setPatientRuleList(patientRules);
        ruleSet.setDosageRuleList(dosageRules);
        ruleSet.setName("Test");
        ruleSet.setMedicineId("69");

        return ruleSet;
    }

    private RuleSet setSecondRuleSet() {
        RuleSet ruleSet = new RuleSet();
        ruleSet.setATCRuleList(new ArrayList<>());
        ruleSet.setDosageRuleList(new ArrayList<>());
        ruleSet.setDurationRuleList(new ArrayList<>());
        ruleSet.setPRKRuleList(new ArrayList<>());
        List<PatientRule> patientRules = new ArrayList<>();
        List<DosageRule> dosageRules = new ArrayList<>();
        PatientRule patientRule = new PatientRule();
        PatientRule patientRule2 = new PatientRule();
        DosageRule dosageRule = new DosageRule();

        patientRule.setAge(75);
        patientRule.setOperator(1);

        dosageRule.setDosage(5);
        dosageRule.setOperator(1);
        dosageRules.add(dosageRule);

        patientRule2.setWeight(80);
        patientRule2.setOperator(1);

        patientRules.add(patientRule);
        patientRules.add(patientRule2);

        ruleSet.setPatientRuleList(patientRules);
        ruleSet.setDosageRuleList(dosageRules);
        ruleSet.setName("Test2");
        ruleSet.setMedicineId("420");

        return ruleSet;
    }
}
