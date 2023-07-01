package cu.cujae.pandora.back.configuration.controller;

import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/config/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<Role> insertLdapRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLdapRole(@PathVariable("id") Long id) {
        roleService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Role> updateLdapRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getLdapRoleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Role> findByRoleName(@PathVariable("name") String name) {
        return new ResponseEntity<>(roleService.findByRoleName(name), HttpStatus.OK);
    }

}