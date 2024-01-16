package main.com.michaels.studentSystem.controllers;

import main.com.michaels.studentSystem.entities.Course;

import java.util.List;

public interface CourseController {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void saveCourse(Course course);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
