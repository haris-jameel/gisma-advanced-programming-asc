package com.gisma.asc.dto.response;

import com.gisma.asc.model.Question;
import jakarta.persistence.*;

import java.util.List;

public class QuizRespDTO {
    private Long id;
    private String title;
    private List<QuestionRespDTO> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionRespDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionRespDTO> questions) {
        this.questions = questions;
    }
}
