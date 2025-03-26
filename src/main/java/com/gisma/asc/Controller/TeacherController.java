package com.gisma.asc.Controller;

import com.gisma.asc.dto.request.CourseReqDTO;
import com.gisma.asc.dto.request.StudentReqDTO;
import com.gisma.asc.dto.request.TeacherReqDTO;
import com.gisma.asc.dto.response.CourseRespDTO;
import com.gisma.asc.dto.response.StudentRespDTO;
import com.gisma.asc.dto.response.TeacherRespDTO;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.service.CourseService;
import com.gisma.asc.service.StudentService;
import com.gisma.asc.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherRespDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public TeacherRespDTO addTeacher(@RequestBody TeacherReqDTO teacherReqDTO) {
        return teacherService.addTeacher(teacherReqDTO);
    }

    @PutMapping
    public TeacherRespDTO updateTeacher(@RequestBody TeacherReqDTO teacherReqDTO) {
        return teacherService.updateTeacher(teacherReqDTO);
    }

    @GetMapping("/{id}")
    public TeacherRespDTO getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.getTeacherById(id);
    }

}

