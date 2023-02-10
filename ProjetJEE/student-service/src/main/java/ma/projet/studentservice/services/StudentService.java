package ma.projet.studentservice.services;

import ma.projet.studentservice.dtos.StudentDto;
import ma.projet.studentservice.entites.Student;
import ma.projet.studentservice.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    // Get Student By Id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    // Save Student
    public Student saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        return studentRepository.save(student);
    }
    // Delete Student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    // Update Student
    public Student updateStudent(StudentDto studentDto,Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null){
            student.setEmail(studentDto.getEmail());
            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            return studentRepository.save(student);
        }

        return null;
    }





}
