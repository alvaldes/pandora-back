package cu.cujae.pandora.back.comms.dto;

import java.util.List;

import lombok.Data;

@Data
public class FacultyDTO {
	private Long id;
    private String facultyName;
    private List<CareerDTO> careers;
    private List<DepartmentDTO> departments;
}
