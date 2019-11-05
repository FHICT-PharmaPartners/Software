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
        context = new
    }

    @BeforeEach
    void setup(){
        repo = new MedicineRepository();
    }

    @AfterEach
    void tearDown(){

    }

    @Test

}
