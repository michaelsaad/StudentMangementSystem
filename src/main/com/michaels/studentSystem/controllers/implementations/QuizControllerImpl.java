package main.com.michaels.studentSystem.controllers.implementations;

import main.com.michaels.studentSystem.controllers.QuizController;
import main.com.michaels.studentSystem.entities.Quiz;
import main.com.michaels.studentSystem.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizControllerImpl implements QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizControllerImpl(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizService.getQuizById(id);
    }

    @Override
    public void saveQuiz(Quiz quiz) {
        quizService.saveQuiz(quiz);
    }

    @Override
    public void updateQuiz(Long id, Quiz quiz) {
        quiz.setId(id);
        quizService.updateQuiz(quiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        quizService.deleteQuiz(id);
    }
}


