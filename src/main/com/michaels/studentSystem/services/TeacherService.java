package main.com.michaels.studentSystem.services;

import main.com.michaels.studentSystem.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    void saveTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Long id);
}
