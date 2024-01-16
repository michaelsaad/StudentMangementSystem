package main.com.michaels.studentSystem.controllers;

import main.com.michaels.studentSystem.entities.Teacher;

import java.util.List;

public interface TeacherController {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    void saveTeacher(Teacher teacher);
    void updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}
