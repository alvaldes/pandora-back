package cu.cujae.pandora.back.comms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.repository.RoleRepository;

public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public Role insertLdapRole(Role r) {
		return roleRepository.insertLdapRole(r);
	}
	
	public void deleteLdapRole(Long id) {
		roleRepository.deleteLdapRole(id);
	}
	
	public Role updateLdapRole(Role r) {
		return roleRepository.updateLdapRole(r);
	}
	
	public List<Role> getAllLdapRoles(){
		return roleRepository.getAllLdapRoles();
	}
	
	public Role getLdapRoleById(Long Id) {
		return roleRepository.getLdapRoleById(Id);
	}
	
	public Role findByRoleName(String name) {
		return roleRepository.findByRolename(name);
	}
		
	}
	

