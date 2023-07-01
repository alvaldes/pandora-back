package cu.cujae.pandora.back.configuration.controller;

import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/config/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserEntity> insertLdapUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLdapUser(@PathVariable("id") Long id) {
        userService.deleteLdapUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserEntity> updateLdapUser(@RequestBody UserEntity userEntity) {
        return new ResponseEntity<>(userService.save(userEntity), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getAllLdapUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getLdapUserById(@PathVariable("id") Long id) {
            return new ResponseEntity<>(userService.getLdapUserById(id), HttpStatus.OK);
    }
}