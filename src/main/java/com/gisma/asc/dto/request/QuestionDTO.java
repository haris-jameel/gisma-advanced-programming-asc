package com.gisma.asc.dto.request;

import com.gisma.asc.model.Question;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.model.QuizOption;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

public class QuestionDTO {
    private String text;
    private String correctAnswer;
    private List<QuizOptionDTO> options;

    public Question toEntity(){
        Question question = new Question();
        question.setText(this.text);
        question.setCorrectAnswer(this.correctAnswer);
        return question;
    }

    public List<QuizOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<QuizOptionDTO> options) {
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
