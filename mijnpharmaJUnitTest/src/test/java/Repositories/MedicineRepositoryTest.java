package Repositories;

import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicineRepositoryTest {
    private MedicineRepository repo;

    @BeforeEach
    void setup(){
        repo = new MedicineRepository();
    }

    @AfterEach
    void tearDown(){

    }
    
}
