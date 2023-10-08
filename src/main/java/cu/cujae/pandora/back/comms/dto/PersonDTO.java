package cu.cujae.pandora.back.comms.dto;

import java.time.LocalDateTime;
import java.util.List;

import cu.cujae.pandora.back.academic.entity.Collaborator;
import cu.cujae.pandora.back.comms.entity.Career;
import cu.cujae.pandora.back.comms.entity.Discipline;
import cu.cujae.pandora.back.comms.entity.SubjectPlan;
import lombok.Data;


@Data
public class PersonDTO {
    private Long id;
    private String personName;
    private String faculty;
    private String department;
    private String teachingCategory;
    private String cientificCategory;
    private String responsability;
    private String ci;
    private String userCondition;
    private String areaDirectory;
    private int existInSource;
    private int disabled;
    private int totalHoursPlan;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime modifiedOn;
    private String modifiedBy;
    private float hoursPosition;
    private float hoursCollaborator;
    private Career career;
    private Discipline discipline;
    private SubjectPlan subjectPlan;
    private List<Collaborator> collaborators;
    
}
