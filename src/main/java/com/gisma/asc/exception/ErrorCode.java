package com.gisma.asc.exception;

public enum ErrorCode {

        COURSE_NOT_FOUND("course.not.found", "Course not found with id: "),
        QUIZ_NOT_FOUND("quiz.not.found", "Quiz not found with id: "),
        QUIZES_NOT_FOUND_BY_COURSE_ID("quizes.not.found.by.course.id", "Quizes not found by course id: "),
        QUIZES_NOT_FOUND("quizes.not.found", "Quizes not found with ids: "),
        COURSE_IDS_NOT_FOUND("course.ids.not.found", "Courses not found against the ids: "),
        COURSES_NOT_FOUND("course.not.found", "Courses not found with ids: "),
        STUDENT_NOT_FOUND("student.not.found", "Student not found with id: "),
        TEACHER_NOT_FOUND("teacher.not.found", "Teacher not found with id: "),
        PLEASE_ATLEAST_ONE_COURSE_ID("student.course.id.required", "Please select atleast one Course id.");

        private final String errorCode;
        private final String description;

        ErrorCode(String errorCode, String description) {
            this.errorCode = errorCode;
            this.description = description;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getDescription() {
            return description;
        }
    }
