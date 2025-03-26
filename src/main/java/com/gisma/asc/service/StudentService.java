package com.gisma.asc.service;

import com.gisma.asc.dto.request.StudentReqDTO;
import com.gisma.asc.dto.response.StudentRespDTO;
import com.gisma.asc.exception.ClientError;
import com.gisma.asc.exception.ErrorCode;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Student;
import com.gisma.asc.repository.CourseRepository;
import com.gisma.asc.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentRespDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(Student::toRespDTO).toList();
    }

    @Transactional
    public StudentRespDTO addStudent(StudentReqDTO studentReqDTO) {
        validateAddStudentReq(studentReqDTO);
        Student student = studentReqDTO.toEntity();
        List<Course> courses = courseRepository.findAllById(studentReqDTO.getCourseIds());
        if(ObjectUtils.isEmpty(courses))
           throw new ClientError(ErrorCode.COURSES_NOT_FOUND, studentReqDTO.getCourseIds().toString());
        Set<Course> courseSet = Set.copyOf(courses);
        student.setCourses(courseSet);
        student = studentRepository.save(student);
        return student.toRespDTO();
    }

    public void validateAddStudentReq(StudentReqDTO studentReqDTO){
        if(ObjectUtils.isEmpty(studentReqDTO.getCourseIds()))
            throw new ClientError(ErrorCode.PLEASE_ATLEAST_ONE_COURSE_ID);
        else {
            List<Course> courses = courseRepository.findAllById(studentReqDTO.getCourseIds());
            if(ObjectUtils.isEmpty(courses)){
                throw new ClientError(ErrorCode.COURSES_NOT_FOUND, studentReqDTO.getCourseIds().toString());
            }
        }
    }

    public StudentRespDTO updateStudent(StudentReqDTO studentReqDTO) {
        Student student = studentRepository.findById(studentReqDTO.getId()).orElseThrow(() -> new ClientError(ErrorCode.STUDENT_NOT_FOUND,studentReqDTO.getId().toString()));
        updateModelByReqDTO(studentReqDTO, student);
        student = studentRepository.save(student);
        return student.toRespDTO();
    }

    public Student updateModelByReqDTO(StudentReqDTO studentReqDTO, Student student){
        if(Objects.nonNull(studentReqDTO.getName()))
            student.setName(studentReqDTO.getName());
        if(Objects.nonNull(studentReqDTO.getEmail()))
            student.setEmail(studentReqDTO.getEmail());
        if(Objects.nonNull(studentReqDTO.getAddress()))
            student.setAddress(studentReqDTO.getAddress());
        if(Objects.nonNull(studentReqDTO.getPhone()))
            student.setPhone(studentReqDTO.getPhone());
        if(Objects.nonNull(studentReqDTO.getPhone()))
            student.setPhone(studentReqDTO.getPhone());
        return student;
    }

    public StudentRespDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.STUDENT_NOT_FOUND,id.toString()));
        return student.toRespDTO();
    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.STUDENT_NOT_FOUND,id.toString()));
        studentRepository.deleteById(id);
    }
}
