package cu.cujae.pandora.back.auth.service;

import cu.cujae.pandora.back.auth.dto.LoginDto;
import cu.cujae.pandora.back.auth.dto.RegisterDto;
import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
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
import cu.cujae.pandora.back.comms.utils.StringUtils;
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
        LdapFullLoginResponse ldapUser = ldapService.getFullLogin(new LdapLoginRequest(loginDto.getUsername(), loginDto.getPassword()));
        if (ldapUser.getCn() == null){
            throw new ServerSideException("LDAP: Unknown error", ErrorCodes.SERVER_UNKNOWN_ERROR.getErrorCode());
        }
        UserEntity user = new UserEntity();
        if (userRepository.existsByUsername(loginDto.getUsername())) {
            user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        }else {
            user = register(new RegisterDto(loginDto.getUsername(), loginDto.getPassword(), ldapUser));
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String stringToken = jwtGenerator.generateToken(authentication);
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

    private UserEntity register(RegisterDto registerDto){
        UserEntity user = UserEntity.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .email(registerDto.getLdapUser().getMail())
                .ci(registerDto.getLdapUser().getCn())
                .name(StringUtils.toTitleCase(registerDto.getLdapUser().getGivenName()))
                .lastname(StringUtils.toTitleCase(registerDto.getLdapUser().getSn()))
                .position(registerDto.getLdapUser().getTitle())
                .status("ACTIVE")
                .build();

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
