package main.com.michaels.studentSystem.services.implementations;

import main.com.michaels.studentSystem.entities.Quiz;
import main.com.michaels.studentSystem.entities.Student;
import main.com.michaels.studentSystem.services.QuizService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate-config.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    @Override
    public List<Quiz> getAllQuizzes() {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM Quiz", Quiz.class).list();
        }
    }

    @Override
    public Quiz getQuizById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Quiz.class, id);
        }
    }

    @Override
    public void saveQuiz(Quiz quiz) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(quiz);
            transaction.commit();
        }
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(quiz);
            transaction.commit();
        }
    }

    @Override
    public void deleteQuiz(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Quiz quiz = session.get(Quiz.class, id);
            session.delete(quiz);
            transaction.commit();
        }
    }
}
