package com.example.tanveer.onetoonemapping.service;

import com.example.tanveer.onetoonemapping.entity.InstructorDetailsEntity;
import com.example.tanveer.onetoonemapping.entity.InstructorEntity;
import com.example.tanveer.onetoonemapping.exception.InstructorNotFoundException;
import com.example.tanveer.onetoonemapping.model.InstructorDetailsRequest;
import com.example.tanveer.onetoonemapping.model.InstructorRequest;
import com.example.tanveer.onetoonemapping.model.InstructorResponse;
import com.example.tanveer.onetoonemapping.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public InstructorResponse createInstructor(InstructorRequest instructorRequest) {
        InstructorEntity instructorEntity = modelToEntityForCreate(instructorRequest);
        instructorRepository.save(instructorEntity);

        InstructorResponse response = new InstructorResponse();
        response.setId(instructorEntity.getId());
        log.info("Instructor created with ID: {}", instructorEntity.getId());

        return response;
    }

    public InstructorRequest getById(Long id) {
        InstructorRequest instructorRequest;
        Optional<InstructorEntity> optionalInstructorEntity = instructorRepository.findById(id);
        if (optionalInstructorEntity.isPresent()) {
            log.info("Retrieved Instructor with ID: {}", id);
            instructorRequest = entityToModel(optionalInstructorEntity.get());
        } else {
            log.error("Failed to retrieve Instructor with ID: {}", id);
            throw new InstructorNotFoundException("Instructor with ID not found: " + id);
        }
        return instructorRequest;
    }

    public List<InstructorRequest> getAll() {
        log.info("Retrieving all Employee");

        List<InstructorRequest> instructorRequestList = instructorRepository.findAll()
                .stream()
                .map(this::entityToModel)
                .toList();
        log.info("Retrieved {} Employee", instructorRequestList.size());
        return instructorRequestList;
    }


    public InstructorRequest updateById(InstructorRequest instructorRequest, Long id) {
        Optional<InstructorEntity> optionalInstructorEntity = instructorRepository.findById(id);
        log.info("Updating Instructor with ID: {}", id);
        if (optionalInstructorEntity.isPresent()){
            InstructorEntity entity = modelToEntityForUpDate(instructorRequest,id);
            instructorRepository.save(entity);
            log.info("Instructor with ID {} updated successfully", id);
        }
        else {
            log.error("Failed to retrieve Instructor with ID: {}", id);
            throw new InstructorNotFoundException("Instructor with ID not found: " + id);
        }
        return instructorRequest;
    }



    public void deleteById(Long id) {
        Optional<InstructorEntity> optionalInstructorEntity = instructorRepository.findById(id);
        if (optionalInstructorEntity.isPresent()){
            log.info("Deleting Instructor with ID: {}", id);
            instructorRepository.deleteById(id);
            log.info("Instructor with ID {} deleted successfully", id);
        }
        else {
            log.error("Failed to retrieve Instructor with ID: {}", id);
            throw new InstructorNotFoundException("Instructor with ID not found: " + id);
        }
    }

    private InstructorEntity modelToEntityForCreate(InstructorRequest instructorRequest) {
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setFirstName(instructorRequest.getFirstName());
        instructorEntity.setLastName(instructorRequest.getLastName());

        InstructorDetailsEntity instructorDetailsEntity = new InstructorDetailsEntity();
        instructorDetailsEntity.setHobby(instructorRequest.getInstructorDetail().getHobby());
        instructorDetailsEntity.setYoutubeChannel(instructorRequest.getInstructorDetail().getYoutubeChannel());

        instructorEntity.setInstructorDetails(instructorDetailsEntity);
        return instructorEntity;
    }

    private InstructorRequest entityToModel(InstructorEntity instructorEntity) {
        InstructorRequest instructorRequest = new InstructorRequest();
        instructorRequest.setId(instructorEntity.getId());
        instructorRequest.setFirstName(instructorEntity.getFirstName());
        instructorRequest.setLastName(instructorEntity.getLastName());

        InstructorDetailsRequest instructorDetailsRequest = new InstructorDetailsRequest();
        instructorDetailsRequest.setId(instructorEntity.getInstructorDetails().getId());
        instructorDetailsRequest.setHobby(instructorEntity.getInstructorDetails().getHobby());
        instructorDetailsRequest.setYoutubeChannel(instructorEntity.getInstructorDetails().getYoutubeChannel());

        instructorRequest.setInstructorDetail(instructorDetailsRequest);
        return instructorRequest;
    }

    private InstructorEntity modelToEntityForUpDate(InstructorRequest instructorRequest, Long id) {
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setId(id);
        instructorEntity.setFirstName(instructorRequest.getFirstName());
        instructorEntity.setLastName(instructorRequest.getLastName());

        InstructorDetailsEntity instructorDetailsEntity = new InstructorDetailsEntity();
        instructorDetailsEntity.setId(instructorRequest.getInstructorDetail().getId()); //Added this line to resolve the issue
        instructorDetailsEntity.setHobby(instructorRequest.getInstructorDetail().getHobby());
        instructorDetailsEntity.setYoutubeChannel(instructorRequest.getInstructorDetail().getYoutubeChannel());

        instructorEntity.setInstructorDetails(instructorDetailsEntity);
        return instructorEntity;
    }




    /*
    * for create : model to entity without id
    * for update : model to entity with id
    * for get    : entity to model with id
    * */


}
