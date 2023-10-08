package cu.cujae.pandora.back.comms.dto;

import java.util.List;

import cu.cujae.pandora.back.comms.entity.SubjectPlan;
import lombok.Data;

@Data
public class YearDTO {
	private Long id;
    private String yearName;
    private List<SubjectPlan> subjectsPlans;
}
