package com.gisma.asc.model;

import com.gisma.asc.dto.request.CourseReqDTO;
import com.gisma.asc.dto.response.CourseRespDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "course")
    private List<Quiz> quizzes;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public CourseRespDTO modelToRespDTO() {
        CourseRespDTO courseRespDTO = new CourseRespDTO();
        courseRespDTO.setName(this.name);
        courseRespDTO.setId(this.id);
        courseRespDTO.setDescription(this.description);
        return courseRespDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
