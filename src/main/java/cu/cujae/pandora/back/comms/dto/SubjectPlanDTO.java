package cu.cujae.pandora.back.comms.dto;

import java.time.LocalDateTime;
import java.util.List;

import cu.cujae.pandora.back.comms.entity.CourseType;
import cu.cujae.pandora.back.comms.entity.Discipline;
import cu.cujae.pandora.back.comms.entity.Person;
import cu.cujae.pandora.back.comms.entity.Semester;
import cu.cujae.pandora.back.comms.entity.Year;
import lombok.Data;


@Data
public class SubjectPlanDTO {
    private Long id;
    private String subjectPlanName;
    private int totalHorasPlan;
    private int cantEvalParciales;
    private int cantPl;
    private boolean examenFinal;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime modifiedOn;
    private String modifiedBy;
    private String idSubjectSigenu;
    private boolean online;
    private int id_department;
    private Discipline discipline;    
    private Year year;
    private Semester semester;
    private CourseType courseType;
    private List<Person> persons;
    
    
}
