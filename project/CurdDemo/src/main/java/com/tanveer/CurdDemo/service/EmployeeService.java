package com.tanveer.CurdDemo.service;

import com.tanveer.CurdDemo.entity.EmployeeEntity;
import com.tanveer.CurdDemo.exception.EmployeeNotFountException;
import com.tanveer.CurdDemo.model.EmployeeRequest;
import com.tanveer.CurdDemo.model.EmployeeResponse;
import com.tanveer.CurdDemo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        log.info("creating a new Employee");
        EmployeeEntity employeeEntity = mapModelToEntityForCreate(employeeRequest);
        employeeRepository.save(employeeEntity);

        EmployeeResponse response = new EmployeeResponse();
        response.setId(employeeEntity.getId());
        log.info("Employee created with ID: {}", employeeEntity.getId());
        return response;
    }

    public EmployeeRequest updateEmployee(EmployeeRequest employeeRequest, Long id) {
        if (id != null) {
            log.info("Updating Employee with ID: {}", id);
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
            if (optionalEmployeeEntity.isPresent()) {
                EmployeeEntity employeeEntity = mapModelToEntityForUpdate(employeeRequest, id);
                employeeRepository.save(employeeEntity);
                log.info("EmployeeEntity with ID {} updated successfully", id);
            } else {
                log.error("Failed to retrieve Employee   ID {} not found", id);
                throw new EmployeeNotFountException("Employee with ID : " + id + " not found");
            }
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return employeeRequest;
    }

    public List<EmployeeRequest> getAllEmployee() {

        log.info("Retrieving all Employee");
        List<EmployeeRequest> employeeRequests = employeeRepository.findAll()
                .stream()
                .map(this::mapEntityToModel)
                .toList();

        log.info("Retrieved {} Employee", employeeRequests.size());
        return employeeRequests;
    }

    public EmployeeRequest getEmployeeByID(Long id) {
        Optional<EmployeeEntity> questionOption = employeeRepository.findById(id);
        if (questionOption.isPresent()) {
            log.info("Retrieved Employee with ID: {}", id);
            return mapEntityToModel(questionOption.get());
        }
        else {
            log.error("Failed to retrieve Employee ID {} not found", id);
            throw new EmployeeNotFountException("Employee with ID : " + id + " not found");
        }
    }
    public EmployeeRequest getByName(String name) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findByFirstName(name);
        if (optionalEmployeeEntity.isPresent()){
            log.info("Retrieved Employee with name: {}", name);
            return mapEntityToModel(optionalEmployeeEntity.get());
        }
        else{
            log.error("Failed to retrieve Employee name {} not found", name);
            throw new EmployeeNotFountException("Employee with name : " + name + " not found");
        }
    }


    public void deleteByID(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()){
            log.info("Deleting Employee with ID: {}", id);
            employeeRepository.deleteById(id);
            log.info("Employee with ID {} deleted successfully", id);
        }
        else{
            log.error("Failed to delete Employee  ID {} not found", id);
            throw new EmployeeNotFountException("Employee with ID : " + id + " not found");
        }
    }

    private EmployeeEntity mapModelToEntityForCreate(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeEntity.setEmail(employeeRequest.getEmail());
        return employeeEntity;
    }

    private EmployeeEntity mapModelToEntityForUpdate(EmployeeRequest employeeRequest, Long id) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeEntity.setEmail(employeeRequest.getEmail());
        return employeeEntity;

    }

    private EmployeeRequest mapEntityToModel(EmployeeEntity employeeEntity) {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setId(employeeEntity.getId());
        employeeRequest.setFirstName(employeeEntity.getFirstName());
        employeeRequest.setLastName(employeeEntity.getLastName());
        employeeRequest.setEmail(employeeEntity.getEmail());
        return employeeRequest;
    }



//     getAll without using stream
/*    public List<EmployeeRequest> getAllEmployee1() {
        log.info("Retrieving all Employee");
        List<EmployeeRequest> employeeRequests = new ArrayList<>();

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        for (EmployeeEntity entity : employeeEntities) {
            EmployeeRequest request = mapEntityToModel(entity);
            employeeRequests.add(request);
        }

        log.info("Retrieved {} Employee", employeeRequests.size());
        return employeeRequests;
    }*/

}
