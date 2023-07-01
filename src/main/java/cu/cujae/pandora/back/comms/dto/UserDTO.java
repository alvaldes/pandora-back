package cu.cujae.pandora.back.comms.dto;

import cu.cujae.pandora.back.comms.entity.Role;
import lombok.Data;

import javax.persistence.*;

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
