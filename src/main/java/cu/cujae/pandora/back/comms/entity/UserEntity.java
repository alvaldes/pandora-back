package cu.cujae.pandora.back.comms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ldap_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

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
    @Column(name = "email")
    private String email;
    @Column(name = "ci")
    private String ci;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "position")
    private String position;
    @Column(name = "status")
    private String status;
}
