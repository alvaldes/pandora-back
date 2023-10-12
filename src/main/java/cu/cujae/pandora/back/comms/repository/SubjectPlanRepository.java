package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.SubjectPlan;

@Repository
public interface SubjectPlanRepository extends CrudRepository<SubjectPlan, Long> {
    Optional<SubjectPlan> findById(String id);

    List<SubjectPlan> findAll();

    Boolean existBySubjectPlanName(String subjectName);

	Optional<SubjectPlan> findBySubjectPlanName(String subjectPlanName);
}