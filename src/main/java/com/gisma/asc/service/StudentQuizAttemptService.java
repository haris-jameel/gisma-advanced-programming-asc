package com.gisma.asc.service;

import com.gisma.asc.dto.request.QuizSubmissionRequest;
import com.gisma.asc.exception.ClientError;
import com.gisma.asc.exception.ErrorCode;
import com.gisma.asc.model.Question;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.model.Student;
import com.gisma.asc.model.StudentQuizAttempt;
import com.gisma.asc.repository.QuestionRepository;
import com.gisma.asc.repository.QuizRepository;
import com.gisma.asc.repository.StudentQuizAttemptRepository;
import com.gisma.asc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentQuizAttemptService {

    private QuizRepository quizRepository;
    private StudentQuizAttemptRepository attemptRepository;
    private QuestionRepository questionRepository;
    private StudentRepository studentRepository;

    public StudentQuizAttemptService(QuizRepository quizRepository, StudentQuizAttemptRepository attemptRepository, QuestionRepository questionRepository, StudentRepository studentRepository) {
        this.quizRepository = quizRepository;
        this.attemptRepository = attemptRepository;
        this.questionRepository = questionRepository;
        this.studentRepository = studentRepository;
    }

    public int evaluateQuiz(QuizSubmissionRequest request) {
        StudentQuizAttempt attempt = attemptRepository.findByQuizIdAndStudentId(request.getQuizId(), request.getStudentId());
        Quiz quiz;
        if (Objects.nonNull(attempt)) {
            quiz = attempt.getQuiz();
        } else {
            // Save the attempt
            attempt = new StudentQuizAttempt();
            Student student = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new ClientError(ErrorCode.STUDENT_NOT_FOUND, request.getStudentId().toString()));
            attempt.setStudent(student); // Assuming student exists
            quiz = quizRepository.findById(request.getQuizId()).orElseThrow(() -> new RuntimeException("Quiz not found"));
            attempt.setQuiz(quiz);
        }
        List<Question> questions = quiz.getQuestions();
        int score = 0;
        for (Question question : questions) {
            String correctAnswer = question.getCorrectAnswer();
            String studentAnswer = request.getResponses().get(question.getId());
            if (correctAnswer.equals(studentAnswer)) {
                score++;
            }
        }
        attempt.setResponses(request.getResponses());
        attempt.setStudentScore(score);
        attempt.setTotalScore(quiz.getQuestions().size());
        attemptRepository.save(attempt);
        return score;
    }
}
