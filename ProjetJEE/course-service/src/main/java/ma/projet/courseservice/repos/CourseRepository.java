package ma.projet.courseservice.repos;

import ma.projet.courseservice.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
