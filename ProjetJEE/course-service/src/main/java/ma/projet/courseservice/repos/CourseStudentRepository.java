package ma.projet.courseservice.repos;

import ma.projet.courseservice.entites.CourseStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Long> {
}
