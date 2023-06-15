package cu.cujae.pandora.back.comms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.repository.UserRepository;

public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserEntity insertLdapUser (UserEntity u) {
		return userRepository.insertLdapUser(u);
	}
	
	public void deleteLdapUser (Long id) {
		userRepository.deleteLdapUser(id);
	}
	
	public UserEntity updateLdapUser (UserEntity u) {
		return userRepository.updateLdapUser(u);
	}
	
	public List <UserEntity> getAllLdapUsers(){
		return userRepository.getAllLdapUsers();
	}
	
	public UserEntity getLdapUserById (Long id) {
		return userRepository.getLdapUserById(id);
	}
	
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public Boolean existsByUsername (String username) {
		return userRepository.existsByUsername(username);
	}
}
