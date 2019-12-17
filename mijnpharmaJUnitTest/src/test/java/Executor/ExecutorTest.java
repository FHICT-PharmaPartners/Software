package Executor;

import nl.pharmapartners.mypharma.library.algorithm.execution.Algorithm;
import nl.pharmapartners.mypharma.library.algorithm.execution.Executor;
import nl.pharmapartners.mypharma.library.model.Diagnosis;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import nl.pharmapartners.mypharma.library.model.enums.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExecutorTest {
    @Test
    void testCheckAll() {
        Patient patient = new Patient(1, "Testpatient", "", "Testpatient", "", "",
                null, 170, 70, Sex.MALE, 10, 72);

        Medicine medicine = new Medicine();
        PatientMedicine patientMedicine = new PatientMedicine();

        //set medicine
        medicine.setMedicineAtc("testMedicine");
        medicine.setId("69");
        patientMedicine.setMedicine(medicine);
        patient.setMedicineList(new ArrayList<>());
        patient.getMedicineList().add(patientMedicine);

        Executor executor = new Executor(patient);
        Diagnosis diagnosis = executor.checkAll();

        assertEquals(true, diagnosis.isPassed());
    }
}
