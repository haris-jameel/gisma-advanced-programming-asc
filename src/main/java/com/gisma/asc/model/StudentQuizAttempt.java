package com.gisma.asc.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Map;

@Entity
public class StudentQuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ElementCollection
    private Map<Long, String> responses; // Question ID -> Selected Answer

    private int studentScore = 0; // Calculated after submission

    private int TotalScore = 0; // Total

    public int getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Map<Long, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<Long, String> responses) {
        this.responses = responses;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }
}

