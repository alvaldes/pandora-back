package cu.cujae.pandora.back.comms.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private Long id;
    
    @Column(name = "course")
    private String course_name;

    @Column(name = "begin_date")
    private Timestamp begin_date;

    @Column(name = "end_date")
    private Timestamp end_date;
 
    @Column(name = "active")
    private boolean active;
}
