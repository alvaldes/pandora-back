package cu.cujae.pandora.back.comms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import cu.cujae.pandora.back.academic.entity.Collaborator;


@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    @Column(name = "name")
    private String personName;
    
    @Column(name = "faculty")
    private String faculty;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "teaching_category")
    private String teachingCategory;
    
    @Column(name = "cientific_category")
    private String cientificCategory;
    
    @Column(name = "responsability")
    private String responsability;
    
    @Column(name = "ci")
    private String ci;
    
    @Column(name = "user_condition")
    private String userCondition;
    
    @Column(name = "area_directorio")
    private String areaDirectory;
    
    @Column(name = "exist_in_source")
    private int existInSource;
    
    @Column(name = "disabled")
    private int disabled;
    
    @Column(name = "total_hours_plan")
    private int totalHoursPlan;
    
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
    
    @Column(name = "modified_by")
    private String modifiedBy;
    
    @Column(name = "horas_cargo")
    private float hoursPosition;
    
    @Column(name = "horas_colaborador")
    private float hoursCollaborator;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_career", nullable = false) 
    private Career career;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_disciplina", nullable = false) 
    private Discipline discipline;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_asignatura", nullable = false) 
    private SubjectPlan subjectPlan;
    
   /* @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Collaborator> collaborators;*/
    
    @ManyToMany(mappedBy = "persons")
    private List<Department> departments;
    
}
