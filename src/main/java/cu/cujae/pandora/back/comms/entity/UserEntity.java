package cu.cujae.pandora.back.comms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ldap_user")
@Data
@NoArgsConstructor
public class UserEntity {


		// TODO Auto-generated constructor stub
	
	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    private String email;
    private String ci;
    private String name;
    private String lastname;
    private String surname;
    private String status;
}
