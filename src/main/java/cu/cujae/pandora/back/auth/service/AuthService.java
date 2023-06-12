package cu.cujae.pandora.back.auth.service;

import cu.cujae.pandora.back.auth.dto.LoginDto;
import cu.cujae.pandora.back.auth.dto.RegisterDto;
import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.Token;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.exception.ServerSideException;
import cu.cujae.pandora.back.comms.repository.RoleRepository;
import cu.cujae.pandora.back.comms.repository.TokenRepository;
import cu.cujae.pandora.back.comms.repository.UserRepository;
import cu.cujae.pandora.back.comms.service.LdapService;
import cu.cujae.pandora.back.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LdapService ldapService;

    public String login(LoginDto loginDto){
        LdapLoginResponse ldapUser = ldapService.getLogin(new LdapLoginRequest(loginDto.getUsername(), loginDto.getPassword()));
        if (ldapUser == null && !ldapUser.getStatus().equals("Active")){
            throw new ServerSideException("LDAP: Unknown error", ErrorCodes.SERVER_UNKNOWN_ERROR.getErrorCode());
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String stringToken = jwtGenerator.generateToken(authentication);
        //UserEntity user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        UserEntity user = userRepository.findByUsername(loginDto.getUsername());
        Token token = Token.builder()
            .token(stringToken)
            .expired(false)
            .revoked(false)
            .user(user)
            .build();
        revokeAllUserTokens(user);
        tokenRepository.save(token);
        return stringToken;
    }

    public UserEntity register(RegisterDto registerDto){
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new InvalidClientRequestException("Username already exists!", ErrorCodes.CLIENT_USERNAME_TAKEN.getErrorCode());
        }
        LdapLoginResponse ldapUser = ldapService.getLogin(new LdapLoginRequest(registerDto.getUsername(), registerDto.getPassword()));
        if (ldapUser == null && !ldapUser.getStatus().equals("Active")){
            throw new ServerSideException("LDAP: Unknown error", ErrorCodes.SERVER_UNKNOWN_ERROR.getErrorCode());
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEmail(ldapUser.getEmail());
        user.setCi(ldapUser.getIdentification());
        user.setName(ldapUser.getName());
        user.setLastname(ldapUser.getLastname());
        user.setSurname(ldapUser.getSurname());
        user.setStatus(ldapUser.getStatus());

        //Role role = roleRepository.findByRolename("USER").get();
        Role role = roleRepository.findByRolename("USER");
        user.setRole(role);

        userRepository.insertLdapUser(user);
        return user;
    }

    private void revokeAllUserTokens(UserEntity user){
        List<Token> validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}
