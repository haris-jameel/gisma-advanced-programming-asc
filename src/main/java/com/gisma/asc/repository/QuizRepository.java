package com.gisma.asc.repository;

import com.gisma.asc.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository Layer
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCourseId(Long courseId);

}
