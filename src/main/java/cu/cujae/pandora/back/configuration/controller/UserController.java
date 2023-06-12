package cu.cujae.pandora.back.configuration.controller;


import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/insertLdapUser")
    public ResponseEntity<Object> insertLdapUser(@RequestBody UserEntity user) { 
    	//va a tomar un objeto UserEntity (que es lo que inserta el user) y cuando llame al metodo insertar lo que lleva para alla es ese objeto
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			UserEntity userCreated = userService.insertLdapUser(user);  
			return new ResponseEntity<Object>(userCreated,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }

    
    @DeleteMapping("/deleteLdapUser/{id}")
    public ResponseEntity<Object> deleteLdapUser(@PathVariable("id") Long id) {
    	Map<String, Object> map = new HashMap<String, Object>();
		try { 
			userService.deleteLdapUser(id);;
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

    
    @PutMapping("/updateLdapUser/{id}") //lo que se pone entre llaves es la variable del path, que es el parametro que se necesita en el metodo
    public ResponseEntity<Object> updateLdapUser(@PathVariable("id") Long id, @RequestBody UserEntity userEntity) { 
    	//El @PathVariable es la variable que me pasan por parametro
    	//El @RequestBody es el objeto que me pasan por parametro que trae todos los datos por los que modificare al user encontrado
    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
    	UserEntity user = userService.getLdapUserById(id);
    	//va a modificar el usuario original que fue el que encontre por cada dato del usuario que me pasaron por parametro que son los datos introducidos por pantalla
    		user.setCi(userEntity.getCi());
    		user.setEmail(userEntity.getEmail());
    		user.getRole().setId(userEntity.getRole().getId());
    		user.setLastname(userEntity.getLastname());
    		user.setName(userEntity.getName());
    		user.setPassword(userEntity.getPassword());
    		user.setStatus(userEntity.getStatus());
    		user.setUsername(userEntity.getUsername());
    		
    		UserEntity userUpdated = userService.updateLdapUser(user);
    		return new ResponseEntity<Object>(userUpdated,HttpStatus.OK);
    	}
    		catch (Exception e) {
    			map.put("message", e.getMessage());
    			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    @GetMapping("/getUsers")
    public ResponseEntity<Object>getUsers() {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
            return new ResponseEntity<>(userService.getAllLdapUsers(), HttpStatus.OK);
        	}
        	catch (Exception e){
        		map.put("message", e.getMessage());
    			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        	}
}
    
    @GetMapping("/getUserById{id}")
    public ResponseEntity<Object> getLdapUserById (@PathVariable("id") Long id) {
    	Map<String, Object> map = new HashMap<String, Object>(); 
        try {
        	UserEntity user = userService.getLdapUserById(id);
			return new ResponseEntity<Object>(user,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }
    
    @GetMapping("/findByUsername{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable("username") String username) {
    	Map<String, Object> map = new HashMap<String, Object>(); 
        try {
        	UserEntity user = userService.findByUsername(username);
			return new ResponseEntity<Object>(user,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
}
