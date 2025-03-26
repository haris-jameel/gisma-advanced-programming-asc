package com.gisma.asc.dto.request;

import com.gisma.asc.enums.UserStatus;
import com.gisma.asc.model.Teacher;

import java.util.List;

public class TeacherReqDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
    private String phone;
    private String address;
    private UserStatus status;
    private List<Long> courseIds;

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Teacher toModel(){
        Teacher teacher = new Teacher();
        teacher.setAddress(this.getAddress());
        teacher.setEmail(this.getEmail());
        teacher.setName(this.getName());
        teacher.setPhone(this.getPhone());
        teacher.setStatus(this.getUserStatus());
        return teacher;
    }

    public UserStatus getUserStatus() {
        return status;
    }

    public void setUserStatus(UserStatus status) {
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

