package com.gisma.asc.dto.response;

import com.gisma.asc.model.Question;
import jakarta.persistence.*;

public class QuizOptionRespDTO {
    private Long id;
    private String text;
    private boolean correct = false;

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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
