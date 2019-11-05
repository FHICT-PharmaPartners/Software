package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;

import javax.swing.plaf.metal.MetalComboBoxEditor;
import java.util.ArrayList;

public class MedicineRepository {

    private ArrayList<Medicine> medicine;
    private MySQLMedicineContext context;

    public MedicineRepository(){
        context = new MySQLMedicineContext();
    }

    public  ArrayList<Medicine> getAllMedicine(){
        if (medicine == null){
            medicine = context.getAllMedicine();
        }

        // Return a copy of the array
        return new ArrayList<>(medicine);
    }

    public Medicine getMedicineById(int id){
        return  context.getMedicineById(id);
    }

    public void addMedicine(Medicine medicine){
        context.addMedicine(medicine);
    }

    private MySQLMedicineContext getContext(){
        if (context == null) {
            context = new MySQLMedicineContext();
        }

        return context;
    }

}
