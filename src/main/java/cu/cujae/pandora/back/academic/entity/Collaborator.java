package cu.cujae.pandora.back.academic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "collaborator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_collaborator")
    private Integer idCollaborator;

    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "id_department")
    private Integer idDepartment;

    @Column(name = "createdon")
    private LocalDateTime createdOn;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifiedon")
    private LocalDateTime modifiedOn;

    @Column(name = "modifiedby")
    private String modifiedBy;
}

