package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.dal.database.MySQLMedication;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.User;

import java.util.ArrayList;

public class MedicationRepository {

    MySQLMedication medicationContext = new MySQLMedication();

    public void addMedication(User user, Medication medication) {
         medicationContext.addMedication(user, medication);
    }
}
