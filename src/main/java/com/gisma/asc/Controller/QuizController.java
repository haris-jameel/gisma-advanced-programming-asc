package com.gisma.asc.Controller;

import com.gisma.asc.dto.request.QuizReqDTO;
import com.gisma.asc.dto.response.QuizRespDTO;
import com.gisma.asc.service.QuizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<QuizRespDTO> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public QuizRespDTO getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PostMapping
    public QuizRespDTO createQuiz(@RequestBody QuizReqDTO quizReqDTO) {
        return quizService.createQuiz(quizReqDTO);
    }

    @GetMapping("/by-course/{id}")
    public List<QuizRespDTO> getQuizzesByCourseId(@PathVariable Long id) {
        return quizService.getQuizzesByCourseId(id);
    }

}
