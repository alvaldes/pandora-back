package cu.cujae.pandora.back.comms.dto;

import java.time.LocalDateTime;
import java.util.List;

import cu.cujae.pandora.back.comms.entity.Career;
import cu.cujae.pandora.back.comms.entity.Department;
import lombok.Data;


@Data
public class DisciplineDTO {
    private Long id;
    private String disciplineName;
    private String idDisciplineSigenu;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime modifiedOn;
    private String modifiedBy;
    private Career career;
    private Department department;
    private List<PersonDTO> persons;
    private List<SubjectPlanDTO> subjectsPlans;
    
    
}
