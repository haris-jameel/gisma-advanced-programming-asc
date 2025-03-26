package com.gisma.asc.dto.request;

import com.gisma.asc.model.Course;
import com.gisma.asc.model.Question;
import com.gisma.asc.model.Quiz;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

public class QuizReqDTO {
    private String title;
    private List<QuestionDTO> questions;
    private Long courseId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public Quiz toEntity(){
        Quiz quiz = new Quiz();
        quiz.setTitle(this.title);
        return quiz;
    }
}
