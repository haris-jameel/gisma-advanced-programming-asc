package com.gisma.asc.dto.request;

import com.gisma.asc.enums.ROLE;
import com.gisma.asc.enums.UserStatus;
import com.gisma.asc.model.Student;

import java.util.List;

public class StudentReqDTO {
    private Long id;
    private String name;
    private String email;
    private ROLE role;
    private UserStatus status;
    private String phone;
    private String address;
    private List<Long> courseIds;

    public Student toEntity() {
        Student student = new Student();
        student.setName(this.name);
        student.setEmail(this.email);
        student.setRole(this.role);
        student.setStatus(this.status);
        student.setPhone(this.phone);
        student.setAddress(this.address);
        return student;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }
}
