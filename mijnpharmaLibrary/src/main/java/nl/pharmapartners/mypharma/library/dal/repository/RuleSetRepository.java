package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.RuleSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleSetRepository extends JpaRepository<RuleSet, String> {
}
