package cu.cujae.pandora.back.auth.service;

import cu.cujae.pandora.back.auth.dto.LoginDto;
import cu.cujae.pandora.back.auth.dto.RegisterDto;
import cu.cujae.pandora.back.comms.entity.Role;
import cu.cujae.pandora.back.comms.entity.Token;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.repository.RoleRepository;
import cu.cujae.pandora.back.comms.repository.TokenRepository;
import cu.cujae.pandora.back.comms.repository.UserRepository;
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

    public String login(LoginDto loginDto){
        //Todo: check if exist in ldap
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String stringToken = jwtGenerator.generateToken(authentication);
        UserEntity user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        Token token = new Token();
        token.setToken(stringToken);
        token.setExpired(false);
        token.setRevoked(false);
        token.setUser(user);
        revokeAllUserTokens(user);
        tokenRepository.save(token);
        return stringToken;
    }

    public UserEntity register(RegisterDto registerDto){
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new InvalidClientRequestException("Username already exists!", ErrorCodes.CLIENT_USERNAME_TAKEN.getErrorCode());
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleRepository.findByRoleName("USER").get();
        user.setRole(role);

        userRepository.save(user);
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
