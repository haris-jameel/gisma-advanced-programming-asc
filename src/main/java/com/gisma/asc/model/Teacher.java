package com.gisma.asc.model;

import com.gisma.asc.dto.response.TeacherRespDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable( name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public TeacherRespDTO toRespDTO(){
        TeacherRespDTO teacherRespDTO = new TeacherRespDTO();
        teacherRespDTO.setName(this.getName());
        teacherRespDTO.setEmail(this.getEmail());
        teacherRespDTO.setAddress(this.getAddress());
        teacherRespDTO.setPhone(this.getPhone());
        return teacherRespDTO;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
