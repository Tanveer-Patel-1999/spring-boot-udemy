package com.example.manytomany.mapper;

import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.entity.EmployeeEntity;
import com.example.manytomany.model.Department;
import com.example.manytomany.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeEntity modelToEntity(Employee employee);

    Employee entityToModel (EmployeeEntity employeeEntity);

    List<Employee> entityToModel (List<EmployeeEntity> employeeEntity);

    DepartmentEntity modelToEntity(Department department);

    Department entityToModel (DepartmentEntity departmentEntity);
}
