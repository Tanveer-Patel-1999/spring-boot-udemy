package com.example.tanveer.onetoonemapping.controller;

import com.example.tanveer.onetoonemapping.model.InstructorRequest;
import com.example.tanveer.onetoonemapping.model.InstructorRequestToMany;
import com.example.tanveer.onetoonemapping.model.InstructorResponse;
import com.example.tanveer.onetoonemapping.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/one-to-many")
public class InstructorToManyController {

    private final CourseService courseService;

    @Autowired
    public InstructorToManyController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/instructors")
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody InstructorRequestToMany request){
        InstructorResponse response = courseService.createInstructor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<InstructorRequestToMany> getById(@PathVariable Long id){
        InstructorRequestToMany request = courseService.getById(id);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<InstructorRequestToMany>> getAll(){
        List<InstructorRequestToMany> request = courseService.getAll();
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @PutMapping("/instructor/{id}")
    public ResponseEntity<InstructorRequestToMany> updateById(@RequestBody InstructorRequestToMany request ,@PathVariable Long id){
        InstructorRequestToMany instructorRequestToMany = courseService.updateById(request, id);
        return new ResponseEntity<>(instructorRequestToMany,HttpStatus.OK);
    }

}
