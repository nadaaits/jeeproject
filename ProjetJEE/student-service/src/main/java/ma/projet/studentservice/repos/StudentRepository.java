package ma.projet.studentservice.repos;

import ma.projet.studentservice.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

