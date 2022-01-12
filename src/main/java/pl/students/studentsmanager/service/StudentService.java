package pl.students.studentsmanager.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.students.studentsmanager.exception.StudentNotFoundException;
import pl.students.studentsmanager.model.Student;
import pl.students.studentsmanager.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private static final int SIZE = 10;
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(Integer page) {
        return studentRepository.findAllStudents(
                PageRequest.of(page, SIZE,
                        Sort.by(Sort.Order.asc("lastName"))
                )
        );
    }

    @Transactional
    public Student updateStudent(Student student) {
        Student updatedStudent = studentRepository
                .findById(student.getId()).orElseThrow();
        updatedStudent.setName(student.getName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setPhone(student.getPhone());
        return updatedStudent;

    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student by " + id + " doesn't exist "));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findByNameAndLastName(String name, String lastName) {
        if (!(studentRepository.ExistByName(name)) || !(studentRepository.ExistByLastName(lastName))) {
            throw new StudentNotFoundException("Student doesn't exist");
        }
        return studentRepository.findByNameAndLastName(name, lastName);
    }
}

