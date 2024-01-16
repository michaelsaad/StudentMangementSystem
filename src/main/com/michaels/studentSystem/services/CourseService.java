package main.com.michaels.studentSystem.services;

import main.com.michaels.studentSystem.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long id);
}
