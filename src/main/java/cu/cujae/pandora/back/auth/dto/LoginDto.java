package cu.cujae.pandora.back.auth.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
