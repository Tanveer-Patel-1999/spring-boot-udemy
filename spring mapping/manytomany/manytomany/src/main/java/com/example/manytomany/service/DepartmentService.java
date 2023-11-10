package com.example.manytomany.service;

import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.mapper.EmployeeMapper;
import com.example.manytomany.model.Department;
import com.example.manytomany.model.DepartmentResponse;
import com.example.manytomany.repository.DepartmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Log4j2
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
    }

    public DepartmentResponse createDepartment(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        DepartmentEntity departmentEntity = employeeMapper.modelToEntity(department);
        departmentRepository.save(departmentEntity);
        log.info("department created successfully");
        departmentResponse.setId(departmentEntity.getId());
        return departmentResponse;
    }

    public Department getDepartmentById(Long id) {
        Optional<DepartmentEntity> optionalDepartmentEntity = departmentRepository.findById(id);
        Department department = new Department();
        if (optionalDepartmentEntity.isPresent()) {
            DepartmentEntity departmentEntity = optionalDepartmentEntity.get();
            department = employeeMapper.entityToModel(departmentEntity);
            log.info("Department found with id {} ", id);
        } else {
            log.info("Department id {} ", id + "not found");
        }
        return department;
    }


    public Department updateDepartmentById(Long id, Department department) {
        Optional<DepartmentEntity> optionalDepartmentEntity = departmentRepository.findById(id);
        if (optionalDepartmentEntity.isPresent()) {
            optionalDepartmentEntity.get().setName(department.getName());
            departmentRepository.save(optionalDepartmentEntity.get());
            log.info("Department updated with id {} ", id);
        } else {
            log.info("Department id {} ", id + "not found");
        }
        return department;

    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
        log.info("Department id {} ", id + "deleted successfully");
    }

}
