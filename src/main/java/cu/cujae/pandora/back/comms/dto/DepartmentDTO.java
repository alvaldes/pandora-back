package cu.cujae.pandora.back.comms.dto;

import java.util.List;

import lombok.Data;


@Data
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private Long idRh;
    private FacultyDTO faculty;
    private List<DisciplineDTO> disciplines;
    private List<PersonDTO> persons;
    
}
