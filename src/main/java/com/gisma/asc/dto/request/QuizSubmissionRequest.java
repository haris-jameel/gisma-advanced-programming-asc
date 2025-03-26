package com.gisma.asc.dto.request;

import java.util.Map;

public class QuizSubmissionRequest {
    private Long studentId;
    private Long quizId;
    private Map<Long, String> responses; // Question ID -> Answer

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Map<Long, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<Long, String> responses) {
        this.responses = responses;
    }
}
