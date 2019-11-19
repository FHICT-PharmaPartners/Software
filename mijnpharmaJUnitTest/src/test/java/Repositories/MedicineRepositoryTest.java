package Repositories;

import contexts.MedicineTestContext;
import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.dal.database.MySQLMedicineContext;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.interfaces.MedicineContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MedicineRepositoryTest {

    private MedicineRepository repo;
    private MedicineContext context;
    private Medicine _medicine;

    public MedicineRepositoryTest() {
        context = new MedicineTestContext();
    }

    @BeforeEach
    void setup() {
        repo = new MedicineRepository(context);
        _medicine = new Medicine(0, "TestMedicatie", "TestDescription");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addMedicine() {

        // Arrange
        Medicine expected = new Medicine(0, "TestMedicatie", "TestDescription");

        // Act
        repo.addMedicine(_medicine);
        Medicine actual = repo.getMedicineById(_medicine.getId());

        // Assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
    }


}
