package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
    Optional<Faculty> findByFacultyName(String facultyName);

    Boolean existsByFacultyName(String facultyName);

    List<Faculty> findAll();
}