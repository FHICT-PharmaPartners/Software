package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;

import java.util.ArrayList;

public class MedicineRepository {

    MySQLMedicineContext medicineContext = new MySQLMedicineContext();

    public ArrayList<Medicine> getAllMedicine() {
        return medicineContext.getAllMedicine();
    }

    public ArrayList<Medicine> getMedicineByName(String name) {
        return medicineContext.getMedicineByName(name);
    }

    public Medicine getMedicineById(int id) {
        return medicineContext.getMedicineById(id);
    }
}
