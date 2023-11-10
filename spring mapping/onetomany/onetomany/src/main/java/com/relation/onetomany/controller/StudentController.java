package com.relation.onetomany.controller;

import com.relation.onetomany.model.StudentRequest;
import com.relation.onetomany.model.StudentResponse;
import com.relation.onetomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService ;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/students")
    public ResponseEntity<StudentResponse>createStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>( studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentRequest>getStudent(@PathVariable Long studentId){
        return new ResponseEntity<>( studentService.getStudent(studentId),HttpStatus.OK);
    }
    @GetMapping("/students")
    public ResponseEntity<List<StudentRequest>>getAllStudent(){
        return new ResponseEntity<>( studentService.getAllStudents(),HttpStatus.OK);
    }

    @PutMapping("/students/{studentId}/hostel/{hostelId}")
    public ResponseEntity<Void>assign(@PathVariable Long studentId , @PathVariable Long hostelId){
        studentService.assign(studentId,hostelId);
        return  ResponseEntity.ok().build();
    }
}