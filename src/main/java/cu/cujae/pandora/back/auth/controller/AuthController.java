package cu.cujae.pandora.back.auth.controller;

import cu.cujae.pandora.back.auth.dto.AuthResponseDto;
import cu.cujae.pandora.back.auth.dto.LoginDto;
import cu.cujae.pandora.back.auth.dto.RegisterDto;
import cu.cujae.pandora.back.auth.service.AuthService;
import cu.cujae.pandora.back.comms.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDto registerDto) {
        UserEntity user = authService.register(registerDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}