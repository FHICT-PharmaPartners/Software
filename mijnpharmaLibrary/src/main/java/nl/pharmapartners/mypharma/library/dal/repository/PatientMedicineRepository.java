package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMedicineRepository extends JpaRepository<PatientMedicine, String> {
    List<PatientMedicine> findByUser(User user);
}
