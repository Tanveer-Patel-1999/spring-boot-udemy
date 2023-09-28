package com.tanveer.quizapp.controller;

import com.tanveer.quizapp.model.QuestionRequest;
import com.tanveer.quizapp.model.QuestionResponse;
import com.tanveer.quizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    @GetMapping("AllQuestions")
    public ResponseEntity<List<QuestionRequest>> getAllQuestion() {
        List<QuestionRequest> questionRequests = questionService.getAllQuestion();
        return new ResponseEntity<>(questionRequests,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<QuestionResponse> createQuestion(@RequestBody QuestionRequest questionRequest){
        QuestionResponse questionResponse = questionService.createQuestion(questionRequest);
        return new ResponseEntity<>(questionResponse,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionRequest> getById(@PathVariable Long id){
        QuestionRequest questionRequest = questionService.getById(id);
        return new ResponseEntity<>(questionRequest,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<QuestionRequest> updatePerson(@RequestBody QuestionRequest request, @PathVariable Long id){
        QuestionRequest questionRequest = questionService.updatePerson(request,id);
        return new ResponseEntity<>(questionRequest,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        questionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionRequest>> getQuestionByCategory(@PathVariable String category){
    List<QuestionRequest> questionRequests = questionService.getQuestionByCategory(category);
    return new ResponseEntity<>(questionRequests,HttpStatus.OK);
    }

}
