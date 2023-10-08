package cu.cujae.pandora.back.configuration.controller;

import cu.cujae.pandora.back.comms.dto.UserDTO;

import cu.cujae.pandora.back.comms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/config/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> insertLdapUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLdapUser(@PathVariable("id") Long id) {
        userService.deleteLdapUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserDTO> updateLdapUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getAllLdapUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getLdapUserById(@PathVariable("id") Long id) {
            return new ResponseEntity<>(userService.getLdapUserById(id), HttpStatus.OK);
    }

    @GetMapping("username/{name}")
    public ResponseEntity<UserDTO> getLdapUserById(@PathVariable("name") String name) {
        return new ResponseEntity<>(userService.findByUsername(name), HttpStatus.OK);
    }
}