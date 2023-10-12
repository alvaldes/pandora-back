package cu.cujae.pandora.back.comms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cu.cujae.pandora.back.comms.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByCourseName(String course_name);

    Boolean existsByCourseName(String course_name);

    List<Course> findAll();
}