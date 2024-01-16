package main.com.michaels.studentSystem.services.implementations;

import main.com.michaels.studentSystem.entities.Student;
import main.com.michaels.studentSystem.services.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    // define the Session factory
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate-config.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();


    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM Student ", Student.class).list();
        }

    }

    @Override
    public Student getStudentById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public void saveStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }

    }

}