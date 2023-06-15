package cu.cujae.pandora.back.configuration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.service.RoleService;
import cu.cujae.pandora.back.comms.service.UserService;

@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/insertLdapUser")
	public ResponseEntity<Object> insertLdapUser (@RequestBody UserEntity u){
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			UserEntity userCreated= userService.insertLdapUser(u);
			return new ResponseEntity<Object>(userCreated, HttpStatus.OK);
		}
		catch(Exception e){
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteLdapUser/{id}")
	public ResponseEntity<Object> deleteLdapUser(@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.deleteLdapUser(id);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		catch(Exception e){
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateLdapUser/{id}")
	public ResponseEntity<Object> updateLdapUser(@PathVariable("id") Long id, @RequestBody UserEntity userEntity){
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			UserEntity u = userService.getLdapUserById(id);
			u.setCi(userEntity.getCi());
			u.setEmail(userEntity.getEmail());
			u.getRole().setId(userEntity.getRole().getId());
			u.setLastname(userEntity.getLastname());
			u.setName(userEntity.getName());
			u.setPassword(userEntity.getPassword());
			u.setPosition(userEntity.getPosition());
			u.setStatus(userEntity.getStatus());
			u.setUsername(userEntity.getUsername());

			UserEntity userUpdated = userService.updateLdapUser(u);
			return new ResponseEntity<Object>(userUpdated, HttpStatus.OK);
		}
		catch(Exception e){
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<Object> getUsers(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return new ResponseEntity<>(userService.getAllLdapUsers(), HttpStatus.OK);
		}
		catch(Exception e){
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getUserById{id}")
	public ResponseEntity<Object> getLdapUserById (@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserEntity user = userService.getLdapUserById(id);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
		catch(Exception e){
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	}
	

