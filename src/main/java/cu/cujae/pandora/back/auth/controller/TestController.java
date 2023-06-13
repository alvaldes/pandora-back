package cu.cujae.pandora.back.auth.controller;

import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.entity.Year;
import cu.cujae.pandora.back.comms.repository.RoleRepository;
import cu.cujae.pandora.back.comms.repository.UserRepository;
import cu.cujae.pandora.back.comms.repository.YearRepository;
import cu.cujae.pandora.back.comms.service.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private YearRepository yearRepository;
    @Autowired
    private LdapService ldapService;

    @PostMapping("ldap-user")
    public LdapLoginResponse getLdapUser(@RequestBody LdapLoginRequest request){
        return ldapService.getLogin(request);
    }
    @GetMapping("users")
    public List<UserEntity> getUsers(){
        return (List<UserEntity>) userRepository.findAll();
    }

    @GetMapping("roles")
    public List<Role> getRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    @GetMapping("years")
    public List<Year> getYears(){
        return (List<Year>) yearRepository.findAll();
    }
}
