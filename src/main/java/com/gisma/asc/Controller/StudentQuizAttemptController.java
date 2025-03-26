package com.gisma.asc.Controller;

import com.gisma.asc.dto.request.QuizSubmissionRequest;
import com.gisma.asc.dto.response.SuccessResponse;
import com.gisma.asc.service.StudentQuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-attempts")
public class StudentQuizAttemptController {
    @Autowired
    private StudentQuizAttemptService attemptService;

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody QuizSubmissionRequest request) {
        int score = attemptService.evaluateQuiz(request);
        return ResponseEntity.ok(new SuccessResponse("Quiz submitted successfully and you score is : " + score,200, true));
    }
}
