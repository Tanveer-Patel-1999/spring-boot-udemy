package com.tanveer.CurdDemo.repository;

import com.tanveer.CurdDemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

//     here findByFirstName : FirstName is field of entity class
    Optional<EmployeeEntity> findByFirstName(String name);
}
