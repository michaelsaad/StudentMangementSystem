package main.com.michaels.studentSystem.services.implementations;

import main.com.michaels.studentSystem.entities.Student;
import main.com.michaels.studentSystem.entities.Teacher;
import main.com.michaels.studentSystem.services.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate-config.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    @Override
    public List<Teacher> getAllTeachers() {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM Teacher", Teacher.class).list();
        }
    }

    @Override
    public Teacher getTeacherById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Teacher.class, id);
        }
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(teacher);
            transaction.commit();
        }
    }

    @Override
    public void deleteTeacher(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            session.delete(teacher);
            transaction.commit();
        }
    }
}

