package cu.cujae.pandora.back.configuration.controller;

import cu.cujae.pandora.back.comms.dto.RoleDTO;
import cu.cujae.pandora.back.comms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<RoleDTO> insertLdapRole(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.save(roleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLdapRole(@PathVariable("id") Long id) {
        roleService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<RoleDTO> updateLdapRole(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.save(roleDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RoleDTO>> getRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getLdapRoleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @GetMapping("role_name/{name}")
    public ResponseEntity<RoleDTO> findByRoleName(@PathVariable("name") String name) {
        return new ResponseEntity<>(roleService.findByRoleName(name), HttpStatus.OK);
    }

}