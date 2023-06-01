package cu.cujae.pandora.back.auth.dto;

import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    LdapFullLoginResponse ldapUser;
}
