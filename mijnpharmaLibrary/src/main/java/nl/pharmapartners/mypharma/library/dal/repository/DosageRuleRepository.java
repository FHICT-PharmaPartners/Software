package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.DosageRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRuleRepository extends JpaRepository<DosageRule, String> {
}
