package main.com.michaels.studentSystem.controllers.implementations;

import main.com.michaels.studentSystem.controllers.StudentController;
import main.com.michaels.studentSystem.entities.Student;
import main.com.michaels.studentSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentService.saveStudent(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        student.setId(id);
        studentService.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentService.deleteStudent(id);
    }
}
