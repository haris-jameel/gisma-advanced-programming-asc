package com.gisma.asc.model;

import com.gisma.asc.dto.request.QuestionDTO;
import com.gisma.asc.dto.response.QuestionRespDTO;
import jakarta.persistence.*;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizOption> options = new ArrayList<>();
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public QuestionRespDTO toRespDTO(){
        QuestionRespDTO questionDTO = new QuestionRespDTO();
        questionDTO.setText(this.text);
        questionDTO.setCorrectAnswer(this.correctAnswer);
        if(!ObjectUtils.isEmpty(this.options))
            questionDTO.setOptions(this.options.stream().map(QuizOption::toResDTO).toList());
        return questionDTO;
    }

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

    public List<QuizOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuizOption> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
