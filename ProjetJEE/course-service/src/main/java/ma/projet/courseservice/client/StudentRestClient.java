package ma.projet.courseservice.client;

import ma.projet.courseservice.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(name = "student-service")
public interface StudentRestClient {
    @RequestMapping("/api/students/allStudents")
    public List<Student> getAllStudents();

    @RequestMapping("/api/students/studentById/{id}")
    public Student getStudentById(@PathVariable Long id);

}
