package main.com.michaels.studentSystem.controllers.implementations;

import main.com.michaels.studentSystem.controllers.TeacherController;
import main.com.michaels.studentSystem.entities.Teacher;
import main.com.michaels.studentSystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherControllerImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherService.getTeacherById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherService.saveTeacher(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        teacher.setId(id);
        teacherService.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherService.deleteTeacher(id);
    }
}
