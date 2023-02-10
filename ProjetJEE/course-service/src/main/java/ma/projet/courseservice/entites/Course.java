package ma.projet.courseservice.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.courseservice.models.Student;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double duration;

    @OneToMany()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CourseStudent> courseStudents= new ArrayList<>();

}
