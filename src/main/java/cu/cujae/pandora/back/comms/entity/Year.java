package cu.cujae.pandora.back.comms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "year")
@Data
@NoArgsConstructor
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_year")
    private Long id;
    
    @Column(name = "year_name")
    private String yearName;
}
