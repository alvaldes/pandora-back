package cu.cujae.pandora.back.comms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "disciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Long id;

    @Column(name = "disciplina_name")
    private String disciplineName;
    
    @Column(name = "id_disciplina_sigenu")
    private String idDisciplineSigenu;
    
    @Column(name = "createdon")
    private LocalDateTime createdOn;
    
    @Column(name = "createdby")
    private String createdBy;
    
    @Column(name = "modifiedon")
    private LocalDateTime modifiedOn;
    
    @Column(name = "modifiedby")
    private String modifiedBy;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCareer", nullable = false) 
    private Career career;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento", nullable = false) 
    private Department department;
    
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Person> persons;
    
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SubjectPlan> subjectsPlans;  
}
