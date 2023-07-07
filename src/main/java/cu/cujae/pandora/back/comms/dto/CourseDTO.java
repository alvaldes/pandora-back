package cu.cujae.pandora.back.comms.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CourseDTO {
	private Long id;
    private String course;
    private Timestamp begin_date;
    private Timestamp end_date;
    private boolean active;

}
