package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Semester;

@Repository
public interface SemesterRepository extends CrudRepository<Semester, Long> {
    Optional<Semester> findBySemesterName(String semesterName);

    List<Semester> findAll();

    Boolean existBySemesterName(String semesterName);
}