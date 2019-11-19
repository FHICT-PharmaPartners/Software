package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.interfaces.MedicineContext;

import javax.swing.plaf.metal.MetalComboBoxEditor;
import java.util.ArrayList;

public class MedicineRepository {

    private MedicineContext context;

    public MedicineRepository(MedicineContext medicineContext){
        context = medicineContext;
    }

    public  ArrayList<Medicine> getAllMedicine(){
        // Return a copy of the array
        return context.getAllMedicine();
    }

    public Medicine getMedicineById(int id){
        return  context.getMedicineById(id);
    }

    public void addMedicine(Medicine medicine){
        context.addMedicine(medicine);
    }

}
