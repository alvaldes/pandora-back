package cu.cujae.pandora.back.comms.dto;

import java.util.List;

import lombok.Data;

@Data
public class SemesterDTO {
	private Long id;
	private String semesterName;
	private List<SubjectPlanDTO> subjectsPlans;

}
