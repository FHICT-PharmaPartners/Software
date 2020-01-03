package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.ATCRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATCRuleRepository extends JpaRepository<ATCRule, String> {
}
