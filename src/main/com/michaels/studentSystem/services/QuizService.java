package main.com.michaels.studentSystem.services;

import main.com.michaels.studentSystem.entities.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> getAllQuizzes();
    Quiz getQuizById(Long id);
    void saveQuiz(Quiz quiz);
    void updateQuiz(Quiz quiz);
    void deleteQuiz(Long id);
}
