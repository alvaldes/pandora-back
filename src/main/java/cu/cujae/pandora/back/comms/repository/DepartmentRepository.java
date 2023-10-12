package cu.cujae.pandora.back.comms.repository;

import cu.cujae.pandora.back.comms.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Optional<Department> findByDepartmentName(String departmentName);

    List<Department> findAll();
    
    Boolean existsByDepartmentName(String departmentName);
}



