package pl.students.studentsmanager.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.students.studentsmanager.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where (s.name = :name) "
            + "and  ( s.lastName =:lastName)")
    Student findByNameAndLastName(@Param("name") String name,
                                  @Param("lastName") String lastName);

    @Query("select count(s) = 1 from Student s where s.name = ?1")
    boolean ExistByName(String name);

    @Query("select count(s) = 1 from Student s where s.lastName = ?1")
    boolean ExistByLastName(String lastName);

    @Query("select s from Student s")
    List<Student> findAllStudents(Pageable pageable);


}
