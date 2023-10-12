package cu.cujae.pandora.back.comms.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {
	private Long id;
    private String courseName;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private boolean active;
    private List<SubjectPlanDTO> subjectsPlans;

}
