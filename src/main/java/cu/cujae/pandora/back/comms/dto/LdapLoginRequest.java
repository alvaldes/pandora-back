package cu.cujae.pandora.back.comms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LdapLoginRequest {
    private String username;
    private String password;
}
