package com.gisma.asc.model;

import com.gisma.asc.dto.request.QuizOptionDTO;
import com.gisma.asc.dto.response.QuizOptionRespDTO;
import jakarta.persistence.*;

@Entity
public class QuizOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean correct = false;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public QuizOptionRespDTO toResDTO() {
        QuizOptionRespDTO quizOptionDTO = new QuizOptionRespDTO();
        quizOptionDTO.setText(this.text);
        quizOptionDTO.setCorrect(this.correct);
        return quizOptionDTO;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}