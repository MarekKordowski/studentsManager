package pl.students.studentsmanager.service;

import org.springframework.stereotype.Service;
import pl.students.studentsmanager.exception.StudentNotFoundException;
import pl.students.studentsmanager.model.Student;
import pl.students.studentsmanager.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student student) {

        Student studentById = studentRepository
                .findById(id).orElseThrow(() -> new StudentNotFoundException("Student by id " + " doesn't Exist"));
        studentById.setName(student.getName());
        studentById.setLastName(student.getLastName());
        studentById.setEmail(student.getEmail());
        studentById.setPhone(student.getPhone());
        return studentRepository.save(studentById);

    }

    public Student findStudentById(Long id) {
        return studentRepository
                .findById(id).orElseThrow(() -> new StudentNotFoundException("Student doesn't exist "));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
