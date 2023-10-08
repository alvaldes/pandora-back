package cu.cujae.pandora.back.comms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "asignatura_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura_plan")
    private Long id;

    @Column(name = "asignatura_name")
    private String subjectPlanName;
    
    @Column(name = "total_horas_plan")
    private int totalHorasPlan;
    
    @Column(name = "cant_eval_parciales")
    private int cantEvalParciales;
    
    @Column(name = "cant_pl")
    private int cantPl;
    
    @Column(name = "examen_final")
    private boolean examenFinal;
    
    @Column(name = "createdon")
    private LocalDateTime createdOn;
    
    @Column(name = "createdby")
    private String createdBy;
    
    @Column(name = "modifiedon")
    private LocalDateTime modifiedOn;
    
    @Column(name = "modifiedby")
    private String modifiedBy;
    
    @Column(name = "id_subject_sigenu")
    private String idSubjectSigenu;
    
    @Column(name = "online")
    private boolean online;
    
    @Column(name = "id_departamento")
    private int id_department;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_disciplina", nullable = false) 
    private Discipline discipline;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "academic_year", nullable = false) 
    private Year year;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_semester", nullable = false) 
    private Semester semester;
    
    /*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course_tipe", nullable = false) 
    private CourseType courseType;*/
 
    @OneToMany(mappedBy = "subjectPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Person> persons;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course", nullable = false) 
    private Course course;
}