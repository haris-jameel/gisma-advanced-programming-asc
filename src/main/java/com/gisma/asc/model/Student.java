package com.gisma.asc.model;

import com.gisma.asc.dto.response.StudentRespDTO;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public StudentRespDTO toRespDTO() {
        StudentRespDTO studentRespDTO = new StudentRespDTO();
        studentRespDTO.setName(this.getName());
        studentRespDTO.setEmail(this.getEmail());
        studentRespDTO.setAddress(this.getAddress());
        studentRespDTO.setRole(this.getRole());
        studentRespDTO.setPhone(this.getPhone());
        return studentRespDTO;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
