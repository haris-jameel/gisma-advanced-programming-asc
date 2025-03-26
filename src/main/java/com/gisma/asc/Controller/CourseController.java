package com.gisma.asc.Controller;

import com.gisma.asc.dto.request.CourseReqDTO;
import com.gisma.asc.dto.request.QuizReqDTO;
import com.gisma.asc.dto.response.CourseRespDTO;
import com.gisma.asc.dto.response.SuccessResponse;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public CourseRespDTO addCourse(@RequestBody CourseReqDTO courseReqDTO) {
        return courseService.addCourse(courseReqDTO);
    }

    @PutMapping
    public CourseRespDTO updateCourse(@RequestBody CourseReqDTO courseReqDTO) {
        return courseService.updateCourse(courseReqDTO);
    }

    @GetMapping("/{id}")
    public CourseRespDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PostMapping("/{id}/quizzes")
    public SuccessResponse addQuizToCourse(@PathVariable Long id, @RequestBody QuizReqDTO quizReqDTO) {
        courseService.addQuizzesToCourse(id, quizReqDTO);
        return new SuccessResponse("Quiz added to course successfully", 200,true);
    }
}
