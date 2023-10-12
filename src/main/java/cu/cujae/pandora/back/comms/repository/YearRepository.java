package cu.cujae.pandora.back.comms.repository;


import cu.cujae.pandora.back.comms.entity.Year;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface YearRepository extends CrudRepository<Year, Long> {
	Optional<Year> findByYearName(String yearName);

    Boolean existsByYearName(String yearName);

    List<Year> findAll();
}