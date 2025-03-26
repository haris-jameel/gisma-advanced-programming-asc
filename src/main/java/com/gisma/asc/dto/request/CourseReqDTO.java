package com.gisma.asc.dto.request;

import com.gisma.asc.model.*;


public class CourseReqDTO {
    private Long id;
    private String name;
    private String description;

    public Course toEntity(){
        Course course = new Course();
        course.setName(this.name);
        course.setDescription(this.description);
        return course;
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

}
