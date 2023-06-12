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
import cu.cujae.pandora.back.comms.service.RoleService;


@RequestMapping("/auth")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/insertLdapRole")
    public ResponseEntity<Object> insertLdapRole(@RequestBody Role r) { 
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			Role roleCreated = roleService.insertLdapRole(r);  
			return new ResponseEntity<Object>(roleCreated,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }

    
    @DeleteMapping("/deleteLdapUser/{id}")
    public ResponseEntity<Object> deleteLdapRole(@PathVariable("id") Long id) {
    	Map<String, Object> map = new HashMap<String, Object>();
		try { 
			roleService.deleteLdapRole(id);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

    
    @PutMapping("/updateLdapRole/{id}") 
    public ResponseEntity<Object> updateLdapUser(@PathVariable("id") Long id, @RequestBody Role role) { 
    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
    	Role r = roleService.getLdapRoleById(id);
    		r.setRoleName(role.getRoleName());
    		
    		Role roleUpdated = roleService.updateLdapRole(role);
    		return new ResponseEntity<Object>(roleUpdated,HttpStatus.OK);
    	}
    		catch (Exception e) {
    			map.put("message", e.getMessage());
    			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    @GetMapping("/getRoles")
    public ResponseEntity<Object>getRoles() {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
            return new ResponseEntity<>(roleService.getAllLdapRoles(), HttpStatus.OK);
        	}
        	catch (Exception e){
        		map.put("message", e.getMessage());
    			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        	}
}
    
    @GetMapping("/getRoleById{id}")
    public ResponseEntity<Object> getLdapRoleById (@PathVariable("id") Long id) {
    	Map<String, Object> map = new HashMap<String, Object>(); 
        try {
        	Role role = roleService.getLdapRoleById(id);
			return new ResponseEntity<Object>(role,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }
    
    @GetMapping("/findByRolename{name}")
    public ResponseEntity<Object> findByRolename(@PathVariable("name") String name) {
    	Map<String, Object> map = new HashMap<String, Object>(); 
        try {
        	Role role = roleService.findByRoleName(name);
			return new ResponseEntity<Object>(role,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
}
