package cu.cujae.pandora.back.comms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.repository.UserRepository;

public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserEntity save (UserEntity user) {
		return userRepository.save(user);
	}
	
	public void deleteLdapUser (Long id) {
		userRepository.deleteById(id);
	}
	
	public List <UserEntity> getAllLdapUsers(){
		return userRepository.findAll();
	}
	
	public UserEntity getLdapUserById (Long id) {
		return userRepository.findById(id).get();
	}
	
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}
	
	public Boolean existsByUsername (String username) {
		return userRepository.existsByUsername(username);
	}
}
