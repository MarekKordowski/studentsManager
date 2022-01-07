package pl.students.studentsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.students.studentsmanager.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
