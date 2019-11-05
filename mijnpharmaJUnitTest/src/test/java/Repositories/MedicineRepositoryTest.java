package Repositories;

import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MedicineRepositoryTest {

    private MedicineRepository repo;

    @BeforeEach
    void setup(){
        repo = new MedicineRepository();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    public MedicineRepository(){
        contexts = new MySQLMedicineContext();
    }

    public  ArrayList<Medicine> getAllMedicine(){
        if (medicine == null){
            medicine = contexts.getAllMedicine();
        }

        // Return a copy of the array
        return new ArrayList<>(medicine);
    }

    public Medicine getMedicineById(int id){
        return  contexts.getMedicineById(id);
    }

    public void addMedicine(Medicine medicine){
        contexts.addMedicine(medicine);
    }

    private MySQLMedicineContext getContext(){
        if (contexts == null) {
            contexts = new MySQLMedicineContext();
        }

        return contexts;
    }

}
