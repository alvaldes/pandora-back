package cu.cujae.pandora.back.comms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
