package main.com.michaels.studentSystem.controllers;

import main.com.michaels.studentSystem.entities.Quiz;

import java.util.List;

public interface QuizController {
    List<Quiz> getAllQuizzes();
    Quiz getQuizById(Long id);
    void saveQuiz(Quiz quiz);
    void updateQuiz(Long id, Quiz quiz);
    void deleteQuiz(Long id);
}
