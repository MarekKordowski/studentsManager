package pl.students.studentsmanager.service;

import org.springframework.stereotype.Service;
import pl.students.studentsmanager.model.Student;
import pl.students.studentsmanager.repository.StudentRepository;

import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }
}
