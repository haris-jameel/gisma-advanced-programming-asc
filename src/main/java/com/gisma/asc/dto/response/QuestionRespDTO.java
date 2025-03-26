package com.gisma.asc.dto.response;

import com.gisma.asc.model.QuizOption;

import java.util.List;

public class QuestionRespDTO {
    private Long id;
    private String text;
    private List<QuizOptionRespDTO> options;
    private String correctAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<QuizOptionRespDTO> getOptions() {
        return options;
    }

    public void setOptions(List<QuizOptionRespDTO> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
