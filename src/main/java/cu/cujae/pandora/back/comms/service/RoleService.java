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
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	public void delete(Long id) {
		roleRepository.deleteById(id);
	}
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	public Role findById(Long id) {
		return roleRepository.findById(id).get();
	}
	public Role findByRoleName (String name) {
		return roleRepository.findByRoleName(name).get();
	}
}
