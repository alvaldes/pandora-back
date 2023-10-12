package cu.cujae.pandora.back.comms.dto;

import lombok.Data;


@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private RoleDTO role;
    private String email;
    private String ci;
    private String name;
    private String lastname;
    private String position;
    private String status;
}
