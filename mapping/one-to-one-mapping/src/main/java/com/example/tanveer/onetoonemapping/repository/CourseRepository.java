package com.example.tanveer.onetoonemapping.repository;

import com.example.tanveer.onetoonemapping.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
