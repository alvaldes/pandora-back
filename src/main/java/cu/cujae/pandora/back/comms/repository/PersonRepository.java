package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByPersonName(String personName);

    Boolean existsByPersonName(String personName);

    List<Person> findAll();
}