package cu.cujae.pandora.back.comms.service;

import cu.cujae.pandora.back.comms.client.LdapClient;
import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import cu.cujae.pandora.back.comms.entity.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public Role getLdapRoleById(Long id) {
		return roleRepository.getLdapRoleById(id);
	}
	
	public Role findByRoleName (String name) {
		return roleRepository.findByRoleName(name);
	}
}
