package com.gisma.asc.dto.request;

import com.gisma.asc.model.Question;
import com.gisma.asc.model.QuizOption;

import java.util.Objects;

public class QuizOptionDTO {
    private String text;
    private boolean correct = false;

    public QuizOption toEntity(){
        QuizOption quizOption = new QuizOption();
        quizOption.setText(this.text);
        quizOption.setCorrect(this.correct);
        return quizOption;
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
