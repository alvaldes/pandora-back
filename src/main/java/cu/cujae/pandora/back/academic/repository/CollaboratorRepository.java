package cu.cujae.pandora.back.academic.repository;

import cu.cujae.pandora.back.academic.entity.Collaborator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, Integer> {
    Optional<Collaborator> findByIdCollaborator(Integer id);

    List<Collaborator> findAllByIdDepartment(Integer departmentId);
    List<Collaborator> findAll();
}



