package com.gisma.asc.service;

import com.gisma.asc.dto.request.TeacherReqDTO;
import com.gisma.asc.dto.response.TeacherRespDTO;
import com.gisma.asc.exception.ClientError;
import com.gisma.asc.exception.ErrorCode;
import com.gisma.asc.model.Course;
import com.gisma.asc.model.Teacher;
import com.gisma.asc.repository.CourseRepository;
import com.gisma.asc.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;

    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository  = courseRepository;
    }

    public List<TeacherRespDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(Teacher::toRespDTO).toList();
    }

    @Transactional
    public TeacherRespDTO addTeacher(TeacherReqDTO teacherReqDTO) {
        validateAddTeacherReq(teacherReqDTO);
        Teacher teacher = teacherReqDTO.toModel();
        teacher.setCourses(courseRepository.findAllById(teacherReqDTO.getCourseIds()));
        teacher = teacherRepository.save(teacher);
        return teacher.toRespDTO();
    }

    public void validateAddTeacherReq(TeacherReqDTO teacherReqDTO){
        if(ObjectUtils.isEmpty(teacherReqDTO.getCourseIds()))
            throw new ClientError(ErrorCode.PLEASE_ATLEAST_ONE_COURSE_ID);
        else {
            List<Course> courses = courseRepository.findAllById(teacherReqDTO.getCourseIds());
            if(ObjectUtils.isEmpty(courses))
                throw new ClientError(ErrorCode.COURSES_NOT_FOUND, teacherReqDTO.getCourseIds().toString());
        }
    }

    public TeacherRespDTO updateTeacher(TeacherReqDTO teacherReqDTO) {
        Teacher teacher = teacherRepository.findById(teacherReqDTO.getId()).orElseThrow(() -> new ClientError(ErrorCode.TEACHER_NOT_FOUND,teacherReqDTO.getId().toString()));
        updateModelByReqDTO(teacherReqDTO, teacher);
        teacher = teacherRepository.save(teacher);
        return teacher.toRespDTO();
    }

    public Teacher updateModelByReqDTO(TeacherReqDTO teacherReqDTO, Teacher teacher){
        if(Objects.nonNull(teacherReqDTO.getName()))
            teacher.setName(teacherReqDTO.getName());
        if(Objects.nonNull(teacherReqDTO.getEmail()))
            teacher.setEmail(teacherReqDTO.getEmail());
        if(Objects.nonNull(teacherReqDTO.getAddress()))
            teacher.setAddress(teacherReqDTO.getAddress());
        if(Objects.nonNull(teacherReqDTO.getPhone()))
            teacher.setPhone(teacherReqDTO.getPhone());
        return teacher;
    }

    public TeacherRespDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.TEACHER_NOT_FOUND,id.toString()));
        return teacher.toRespDTO();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.findById(id).orElseThrow(() -> new ClientError(ErrorCode.TEACHER_NOT_FOUND,id.toString()));
        teacherRepository.deleteById(id);
    }
}

