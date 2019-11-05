package contexts;

import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.interfaces.MedicineContext;
import nl.pharmapartners.mypharma.library.parsers.MedicineListParser;

import java.util.ArrayList;

public class MedicineTestContext implements MedicineContext {

    private ArrayList<Medicine> medicines;

    public MedicineTestContext() {
        medicines = new ArrayList<>();
    }

    public ArrayList<Medicine> getAllMedicine() {

        return this.medicines;
    }

    public Medicine getMedicineById(int id) {
        return medicines.get(id);
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
}
