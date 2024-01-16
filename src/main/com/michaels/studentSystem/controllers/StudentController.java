package main.com.michaels.studentSystem.controllers;

import main.com.michaels.studentSystem.entities.Student;

import java.util.List;

public interface StudentController {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
