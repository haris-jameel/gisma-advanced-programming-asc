package com.gisma.asc.repository;

import com.gisma.asc.model.Quiz;
import com.gisma.asc.model.StudentQuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentQuizAttemptRepository extends JpaRepository<StudentQuizAttempt, Long> {
    StudentQuizAttempt findByQuizIdAndStudentId(Long quizId, Long studentId);
}
