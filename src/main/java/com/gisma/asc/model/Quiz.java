package com.gisma.asc.model;

import com.gisma.asc.dto.response.QuizRespDTO;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

    @ManyToOne
    private Course course;

    public QuizRespDTO toRespDTO(){
        QuizRespDTO quizRespDTO = new QuizRespDTO();
        quizRespDTO.setId(this.id);
        quizRespDTO.setTitle(this.title);
        if(this.questions != null){
            quizRespDTO.setQuestions(this.questions.stream().map(Question::toRespDTO).toList());
        }
        return quizRespDTO;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}