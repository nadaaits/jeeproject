package ma.projet.courseservice.models;

import lombok.Data;

@Data
public class Student {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
}
