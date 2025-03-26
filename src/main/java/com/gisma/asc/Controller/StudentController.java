package com.gisma.asc.Controller;

import com.gisma.asc.dto.request.CourseReqDTO;
import com.gisma.asc.dto.request.StudentReqDTO;
import com.gisma.asc.dto.response.CourseRespDTO;
import com.gisma.asc.dto.response.StudentRespDTO;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.service.CourseService;
import com.gisma.asc.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentRespDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentRespDTO addStudent(@RequestBody StudentReqDTO studentReqDTO) {
        return studentService.addStudent(studentReqDTO);
    }

    @PutMapping
    public StudentRespDTO updateStudent(@RequestBody StudentReqDTO studentReqDTO) {
        return studentService.updateStudent(studentReqDTO);
    }

    @GetMapping("/{id}")
    public StudentRespDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
