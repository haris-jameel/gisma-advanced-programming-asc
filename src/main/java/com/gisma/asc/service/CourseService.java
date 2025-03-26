package com.gisma.asc.service;

import com.gisma.asc.dto.request.CourseReqDTO;
import com.gisma.asc.dto.request.QuizReqDTO;
import com.gisma.asc.dto.response.CourseRespDTO;
import com.gisma.asc.exception.ClientError;
import com.gisma.asc.exception.ErrorCode;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Quiz;
import com.gisma.asc.repository.CourseRepository;
import com.gisma.asc.repository.QuestionRepository;
import com.gisma.asc.repository.QuizOptionRepository;
import com.gisma.asc.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private QuizOptionRepository quizOptionRepository;

    public CourseService(CourseRepository courseRepository, QuizRepository quizRepository, QuestionRepository questionRepository, QuizOptionRepository quizOptionRepository) {
        this.courseRepository = courseRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.quizOptionRepository = quizOptionRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseRespDTO addCourse(CourseReqDTO courseReqDTO) {
        Course course = courseReqDTO.toEntity();
        course = courseRepository.save(course);
        return course.modelToRespDTO();
    }

    public CourseRespDTO updateCourse(CourseReqDTO courseReqDTO) {
        Course course = courseRepository.findById(courseReqDTO.getId()).orElseThrow(() -> new ClientError(ErrorCode.COURSE_NOT_FOUND,courseReqDTO.getId().toString()));
        updateModelByReqDTO(courseReqDTO, course);
        course = courseRepository.save(course);
        return course.modelToRespDTO();
    }

    public Course updateModelByReqDTO(CourseReqDTO courseReqDTO, Course course){
        course.setName(courseReqDTO.getName());
        course.setDescription(courseReqDTO.getDescription());
        return course;
    }

    public CourseRespDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.COURSE_NOT_FOUND,id.toString()));
        return course.modelToRespDTO();
    }

    public void deleteCourse(Long id) {
        courseRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.COURSE_NOT_FOUND,id.toString()));
        courseRepository.deleteById(id);
    }

    @Transactional
    public void addQuizzesToCourse(Long id, QuizReqDTO quizReqDTO) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.COURSE_NOT_FOUND,id.toString()));
        Quiz quiz = quizReqDTO.toEntity();
        quiz.setCourse(course);
        quizRepository.save(quiz);
    }
}
