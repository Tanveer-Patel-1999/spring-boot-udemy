package com.example.manytomany.service;

import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.entity.EmployeeEntity;
import com.example.manytomany.mapper.EmployeeMapper;
import com.example.manytomany.model.Employee;
import com.example.manytomany.model.EmployeeResponse;
import com.example.manytomany.repository.DepartmentRepository;
import com.example.manytomany.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;


    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;

    }

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        log.info("employee created successfully!");
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;
    }

    public List<Employee> getAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> cartRequests = employeeMapper.entityToModel(employeeEntities);
        log.info("getting all employee.....");
        return cartRequests;
    }

    public Employee getEmployeeById(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        Employee employee = new Employee();
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employee = employeeMapper.entityToModel(employeeEntity);
            log.info("employee found with id {} ", id);
        } else {
            log.info("employee id {} ", id + "not found");
        }
        return employee;
    }

    public void updateEmployeeById(Long id, Employee employee) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()) {
            optionalEmployeeEntity.get().setFirstName(employee.getFirstName());
            optionalEmployeeEntity.get().setLastName(employee.getLastName());
            employeeRepository.save(optionalEmployeeEntity.get());
            log.info("employee updated with id {} ", id);
        } else {
            log.info("employee id {} ", id + "not found");
        }
    }


    public void updateEmployee(Long empId, Long id) {
        Set<DepartmentEntity> departmentEntities = null;
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElseThrow();
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow();
        departmentEntities = employeeEntity.getDepartment();
        departmentEntities.add(departmentEntity);
        employeeEntity.setDepartment(departmentEntities);
        employeeRepository.save(employeeEntity);
        employeeMapper.entityToModel(employeeEntity);

    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        log.info("employee id {} ", id + "deleted successfully");
    }
}

