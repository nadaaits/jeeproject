package ma.projet.studentservice.controller;

import ma.projet.studentservice.dtos.StudentDto;
import ma.projet.studentservice.entites.Student;
import ma.projet.studentservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    // Get All Students
    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student By Id
    @GetMapping("/studentById/{id}")
    public Student getStudentById(@PathVariable  Long id) {
        return studentService.getStudentById(id);
    }

    // Save Student
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    // Delete Student
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Update Student
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody StudentDto studentDto, @RequestParam Long id) {
        return studentService.updateStudent(studentDto, id);
    }

}
