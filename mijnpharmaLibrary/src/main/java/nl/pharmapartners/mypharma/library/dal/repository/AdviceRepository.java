package nl.pharmapartners.mypharma.library.dal.repository;

import nl.pharmapartners.mypharma.library.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, String> {
}
