package com.example.tanveer.onetoonemapping.controller;

import com.example.tanveer.onetoonemapping.model.InstructorRequest;
import com.example.tanveer.onetoonemapping.model.InstructorResponse;
import com.example.tanveer.onetoonemapping.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/one-to-one")
@Slf4j
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/instructors")
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody InstructorRequest instructorRequest){
        InstructorResponse response= instructorService.createInstructor(instructorRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InstructorRequest> getById(@PathVariable Long id){
        InstructorRequest request = instructorService.getById(id);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<InstructorRequest>> getAll(){
        List<InstructorRequest> requests = instructorService.getAll();
        return new ResponseEntity<>(requests,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorRequest> updateById(@RequestBody InstructorRequest request , @PathVariable Long id){
        InstructorRequest instructorRequest = instructorService.updateById(request,id);
        return new ResponseEntity<>(instructorRequest,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        instructorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
