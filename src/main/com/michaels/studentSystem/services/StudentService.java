package main.com.michaels.studentSystem.services;

import main.com.michaels.studentSystem.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
