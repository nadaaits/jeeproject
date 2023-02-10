package ma.projet.courseservice.controllers;

import lombok.AllArgsConstructor;
import ma.projet.courseservice.client.StudentRestClient;
import ma.projet.courseservice.dtos.CourseDto;
import ma.projet.courseservice.entites.Course;
import ma.projet.courseservice.entites.CourseStudent;
import ma.projet.courseservice.models.Student;
import ma.projet.courseservice.repos.CourseRepository;
import ma.projet.courseservice.repos.CourseStudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    CourseRepository courseRepository;
    CourseStudentRepository courseStudentRepository;
    StudentRestClient studentRestClient;


    @GetMapping("/allCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/addCourse")
    public Course addCourse(CourseDto courseDto){
        Course course = new Course();

        course.setTitle("geo");
        course.setDescription("description 1");
        course.setDuration(1);


        courseRepository.save(course);
        return course;

    }

    @PostMapping("/addStudentToCourse")
    public boolean addStudentToCourse(@RequestParam Long courseId,@RequestParam Long studentId){

        Student student = studentRestClient.getStudentById(studentId);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (student != null && course != null){
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setStudent(student);

            course.getCourseStudents().add(courseStudent);
            courseRepository.save(course);

            return true;
        }
        return false;
    }



}
