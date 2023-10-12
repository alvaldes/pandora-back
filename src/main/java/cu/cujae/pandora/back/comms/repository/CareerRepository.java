package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Career;


@Repository
public interface CareerRepository extends CrudRepository<Career, Long> {
    Optional<Career> findByCareerName(String careerName);

    Boolean existsByCareerName(String careerName);

    List<Career> findAll();

}