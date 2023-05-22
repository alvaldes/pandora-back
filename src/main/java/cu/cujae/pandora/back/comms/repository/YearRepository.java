package cu.cujae.pandora.back.comms.repository;

import cu.cujae.pandora.back.comms.entity.Year;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year, Long> {
}