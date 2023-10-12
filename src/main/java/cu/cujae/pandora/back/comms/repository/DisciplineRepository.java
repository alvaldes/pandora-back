package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Discipline;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Long> {
    Optional<Discipline> findByDisciplineName(String disciplineName);

    Boolean existByDisciplineName(String disciplineName);

    List<Discipline> findAll();
}