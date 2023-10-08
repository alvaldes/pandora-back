package cu.cujae.pandora.back.comms.dto;

import java.util.List;


import lombok.Data;

@Data
public class CareerDTO {
	private Long id;
    private String careerName;
    private FacultyDTO faculty;
    private List<DisciplineDTO> disciplines;
    private List<PersonDTO> persons;
}
