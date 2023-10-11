package com.tanveer.CurdDemo.rest;

import com.tanveer.CurdDemo.model.StudentRequest;
import com.tanveer.CurdDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentRequest>> getAllStudents(){
       return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    private ResponseEntity<StudentRequest> getById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getById(id),HttpStatus.OK);
    }
}
