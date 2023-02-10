package ma.projet.courseservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.courseservice.models.Student;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;



    @Transient
    private Student student;

}
