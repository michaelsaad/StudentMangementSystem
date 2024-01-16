package main.com.michaels.studentSystem.controllers.implementations;

import main.com.michaels.studentSystem.controllers.CourseController;
import main.com.michaels.studentSystem.entities.Course;
import main.com.michaels.studentSystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseControllerImpl implements CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }



    @Override
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseService.getCourseById(id);
    }

    @Override
    public void saveCourse(Course course) {
        courseService.saveCourse(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        course.setId(id);
        courseService.updateCourse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseService.deleteCourse(id);
    }
}
