package main.com.michaels.studentSystem.services.implementations;

import main.com.michaels.studentSystem.entities.Course;
import main.com.michaels.studentSystem.entities.Student;
import main.com.michaels.studentSystem.services.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate-config.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    @Override
    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }

    @Override
    public Course getCourseById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Course.class, id);
        }
    }

    @Override
    public void saveCourse(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        }
    }

    @Override
    public void updateCourse(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        }
    }

    @Override
    public void deleteCourse(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, id);
            session.delete(course);
            transaction.commit();
        }
    }

}
