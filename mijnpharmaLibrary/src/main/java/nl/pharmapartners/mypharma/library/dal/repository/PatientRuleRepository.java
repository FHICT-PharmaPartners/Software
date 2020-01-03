package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.PatientRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRuleRepository extends JpaRepository<PatientRule, String> {
}
