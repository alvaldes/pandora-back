package cu.cujae.pandora.back.security;

import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.repository.RoleRepository;
import cu.cujae.pandora.back.comms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    	UserEntity user = userRepository.findByUsername(username);
    	List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
//        return new User(user.getUsername(), user.getPassword(),
//                mapRolesToAuthorities(roles));

        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .disabled(false)
                .authorities(mapRolesToAuthorities(roles)).build();
        return userDetails;
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
