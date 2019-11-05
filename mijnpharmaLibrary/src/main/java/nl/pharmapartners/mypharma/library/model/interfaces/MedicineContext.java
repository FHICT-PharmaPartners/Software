package nl.pharmapartners.mypharma.library.model.interfaces;

import nl.pharmapartners.mypharma.library.model.Medicine;

import java.util.ArrayList;

public interface MedicineContext {

    ArrayList<Medicine> getAllMedicine();

    Medicine getMedicineById(int id);

    void addMedicine(Medicine medicine);

}
