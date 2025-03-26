package com.gisma.asc.service;

import com.gisma.asc.dto.request.QuestionDTO;
import com.gisma.asc.dto.request.QuizOptionDTO;
import com.gisma.asc.dto.request.QuizReqDTO;
import com.gisma.asc.dto.response.QuizRespDTO;
import com.gisma.asc.exception.ClientError;
import com.gisma.asc.exception.ErrorCode;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Question;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.model.QuizOption;
import com.gisma.asc.repository.CourseRepository;
import com.gisma.asc.repository.QuestionRepository;
import com.gisma.asc.repository.QuizOptionRepository;
import com.gisma.asc.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private QuizRepository quizRepository;
    private CourseRepository courseRepository;
    private QuizOptionRepository quizOptionRepository;
    private QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, CourseRepository courseRepository, QuizOptionRepository quizOptionRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
        this.quizOptionRepository = quizOptionRepository;
        this.questionRepository = questionRepository;
    }


    public List<QuizRespDTO> getAllQuizzes() {
        return quizRepository.findAll().stream().map(Quiz::toRespDTO).toList();
    }

    public QuizRespDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.QUIZ_NOT_FOUND, id.toString()));
        return quiz.toRespDTO();
    }

    @Transactional
    public QuizRespDTO createQuiz(QuizReqDTO quizReqDTO) {
        Course course = courseRepository.findById(quizReqDTO.getCourseId()).orElseThrow(() -> new ClientError(ErrorCode.COURSE_NOT_FOUND, quizReqDTO.getCourseId().toString()));
        /* create quiz */
        Quiz quiz = quizReqDTO.toEntity();
        quiz = quizRepository.save(quiz);
        List<Question> questions = new ArrayList<>();
        /* create questions */
        for (QuestionDTO questionDTO : quizReqDTO.getQuestions()) {
            Question question = questionDTO.toEntity();
            question.setQuiz(quiz);
            question = questionRepository.save(question);
            Question finalQuestion = question;
            /* create quiz options */
            questionDTO.getOptions().forEach(optionDTO -> {
                QuizOption quizOption = optionDTO.toEntity();
                quizOption.setQuestion(finalQuestion);
                quizOption = quizOptionRepository.save(quizOption);
                finalQuestion.getOptions().add(quizOption);
            });
            questions.add(finalQuestion);
        }
        Quiz finalQuiz = quiz;
        questions.forEach(question -> question.setQuiz(finalQuiz));
        quiz.setQuestions(questions);
        quiz = quizRepository.save(quiz);
        return quiz.toRespDTO();
    }

    public List<QuizRespDTO> getQuizzesByCourseId(Long id) {
        List<Quiz> quizes = quizRepository.findByCourseId(id);
        if(quizes.isEmpty())
            throw new ClientError(ErrorCode.QUIZES_NOT_FOUND_BY_COURSE_ID, id.toString());
        return quizes.stream().map(Quiz::toRespDTO).toList();
    }
}
