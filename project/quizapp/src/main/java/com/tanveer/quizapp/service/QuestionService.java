package com.tanveer.quizapp.service;

import com.tanveer.quizapp.entity.QuestionEntity;
import com.tanveer.quizapp.model.QuestionRequest;
import com.tanveer.quizapp.model.QuestionResponse;
import com.tanveer.quizapp.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionResponse createQuestion(QuestionRequest questionRequest) {
        log.info("Creating a new question");

        QuestionEntity questionEntity = mapModelToEntityForCreate(questionRequest);
        questionRepository.save(questionEntity);

        QuestionResponse response = new QuestionResponse();
        response.setId(questionEntity.getId());
        log.info("Question created with ID: {}", questionEntity.getId());
        return response;
    }

    public List<QuestionRequest> getAllQuestion() {
        log.info("Retrieving all questions");
        List<QuestionRequest> questionRequests = questionRepository.findAll().stream()
                .map(this::mapEntityToModel)
                .collect(Collectors.toList());

        log.info("Retrieved {} questions", questionRequests.size());
        return questionRequests;
    }

    public QuestionRequest getById(Long id) {
        Optional<QuestionEntity> questionOption = questionRepository.findById(id);
        if (questionOption.isPresent()) {
            log.info("Retrieved QuestionEntity with ID: {}", id);
            return mapEntityToModel(questionOption.get());
        } else {
            log.error("Failed to retrieve QuestionEntity: ID {} not found", id);
            throw new EntityNotFoundException("QuestionEntity with ID " + id + " not found");
        }
    }

    public List<QuestionRequest> getQuestionByCategory(String category) {
        log.info("Retrieving questions by category: {}", category);

        List<QuestionRequest> questionRequests = questionRepository.findByCategory(category).stream()
                .map(this::mapEntityToModel)
                .collect(Collectors.toList());

        log.info("Retrieved {} questions for category: {}", questionRequests.size(), category);
        return questionRequests;
    }

    public QuestionRequest updatePerson(QuestionRequest request, Long id) {
        if (id != null) {
            log.info("Updating QuestionEntity with ID: {}", id);
            QuestionEntity updatedEntity = mapModelToEntityForUpdate(request, id);
            questionRepository.save(updatedEntity);
            log.info("QuestionEntity with ID {} updated successfully", id);
        } else {
            log.error("Failed to update QuestionEntity: id must not be null");
            throw new IllegalArgumentException("id must not be null");
        }
        return request;
    }

    public void deleteById(Long id) {
        Optional<QuestionEntity> entity = questionRepository.findById(id);
        if (entity.isPresent()) {
            log.info("Deleting QuestionEntity with ID: {}", id);
            questionRepository.deleteById(id);
            log.info("QuestionEntity with ID {} deleted successfully", id);
        } else {
            log.error("Failed to delete QuestionEntity: ID {} not found", id);
            throw new EntityNotFoundException("QuestionEntity with ID " + id + " not found");
        }
    }


    private QuestionRequest mapEntityToModel(QuestionEntity questionEntity) {
        QuestionRequest questionRequest = new QuestionRequest();
        questionRequest.setId(questionEntity.getId());
        questionRequest.setQuestionTitle(questionEntity.getQuestionTitle());
        questionRequest.setOptions1(questionEntity.getOptions1());
        questionRequest.setOptions2(questionEntity.getOptions2());
        questionRequest.setOptions3(questionEntity.getOptions3());
        questionRequest.setOptions4(questionEntity.getOptions4());
        questionRequest.setRightAnswer(questionEntity.getRightAnswer());
        questionRequest.setDifficultyLevel(questionEntity.getDifficultyLevel());
        questionRequest.setCategory(questionEntity.getCategory());
        return questionRequest;
    }

//     for create id is not required
     private QuestionEntity mapModelToEntityForCreate(QuestionRequest questionRequest) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionTitle(questionRequest.getQuestionTitle());
        questionEntity.setOptions1(questionRequest.getOptions1());
        questionEntity.setOptions2(questionRequest.getOptions2());
        questionEntity.setOptions3(questionRequest.getOptions3());
        questionEntity.setOptions4(questionRequest.getOptions4());
        questionEntity.setRightAnswer(questionRequest.getRightAnswer());
        questionEntity.setDifficultyLevel(questionRequest.getDifficultyLevel());
        questionEntity.setCategory(questionRequest.getCategory());
        return questionEntity;
    }

//    for update id is required
    private QuestionEntity mapModelToEntityForUpdate(QuestionRequest questionRequest,Long id) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(id);
        questionEntity.setQuestionTitle(questionRequest.getQuestionTitle());
        questionEntity.setOptions1(questionRequest.getOptions1());
        questionEntity.setOptions2(questionRequest.getOptions2());
        questionEntity.setOptions3(questionRequest.getOptions3());
        questionEntity.setOptions4(questionRequest.getOptions4());
        questionEntity.setRightAnswer(questionRequest.getRightAnswer());
        questionEntity.setDifficultyLevel(questionRequest.getDifficultyLevel());
        questionEntity.setCategory(questionRequest.getCategory());
        return questionEntity;
    }

}
