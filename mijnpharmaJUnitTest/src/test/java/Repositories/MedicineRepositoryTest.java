package Repositories;

import contexts.MedicineTestContext;
import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MedicineRepositoryTest {

    private ArrayList<Medicine> medicine;
    private MedicineTestContext context;

    public MedicineRepositoryTest(){
        context = new MedicineTestContext();
    }

    @BeforeEach
    void setup(){
    }

    @AfterEach
    void tearDown(){
    }

    @Test
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

    private MedicineTestContext getContext(){
        if (context == null) {
            context = new MedicineTestContext();
        }

        return context;
    }
}
