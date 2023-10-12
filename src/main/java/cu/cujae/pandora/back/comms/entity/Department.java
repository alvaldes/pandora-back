package cu.cujae.pandora.back.comms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento")
    private Long id;

    @Column(name = "departamento")
    private String departmentName;
    
    @Column(name = "id_rh")
    private Long idRh;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idfacultad", nullable = false) 
    private Faculty faculty;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discipline> disciplines;

    @ManyToMany
    @JoinTable(
        name = "person_department",
                joinColumns = @JoinColumn(name = "id_department"),
                inverseJoinColumns = @JoinColumn(name = "id_person")
    )
    private List<Person> persons;
}
