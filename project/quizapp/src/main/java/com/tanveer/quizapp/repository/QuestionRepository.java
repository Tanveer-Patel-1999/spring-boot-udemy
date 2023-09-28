package com.tanveer.quizapp.repository;

import com.tanveer.quizapp.entity.QuestionEntity;
import com.tanveer.quizapp.model.QuestionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    List<QuestionEntity> findByCategory(String category);
}
