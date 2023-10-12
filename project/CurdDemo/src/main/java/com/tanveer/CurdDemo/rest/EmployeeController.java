package com.tanveer.CurdDemo.rest;

import com.tanveer.CurdDemo.model.EmployeeRequest;
import com.tanveer.CurdDemo.model.EmployeeResponse;
import com.tanveer.CurdDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse response = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeRequest> updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id){
        EmployeeRequest request = employeeService.updateEmployee(employeeRequest,id);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeRequest>> getAllEmployee(){
        List<EmployeeRequest> employeeRequests = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeRequests,HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeRequest> getEmployeeByID(@PathVariable Long id){
        EmployeeRequest employeeRequest = employeeService.getEmployeeByID(id);
        return new ResponseEntity<>(employeeRequest,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id){
        employeeService.deleteByID(id);
        return ResponseEntity.ok().build();
    }

//    when u custom query for to retrieve then used proper URl : /employees/name/{name}
    @GetMapping("/employees/firstName/{name}")
    public ResponseEntity<EmployeeRequest> getByName(@PathVariable String name){
        EmployeeRequest employeeRequest = employeeService.getByName(name);
        return new ResponseEntity<>(employeeRequest,HttpStatus.OK);
    }
}
