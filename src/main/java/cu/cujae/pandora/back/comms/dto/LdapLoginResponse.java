package cu.cujae.pandora.back.comms.dto;

import lombok.Data;


@Data
public class LdapLoginResponse {
    private String email;
    private String identification;
    private String lastname;
    private String name;
    private String role;
    private String status;
    private String surname;
    private String username;
}
