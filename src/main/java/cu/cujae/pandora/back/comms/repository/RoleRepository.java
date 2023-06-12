package cu.cujae.pandora.back.comms.repository;

import cu.cujae.pandora.back.comms.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Optional<Role> findByRoleName(String role);
}