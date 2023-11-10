package com.example.tanveer.onetoonemapping.service;

import com.example.tanveer.onetoonemapping.entity.CourseEntity;
import com.example.tanveer.onetoonemapping.entity.InstructorDetailsEntity;
import com.example.tanveer.onetoonemapping.entity.InstructorEntity;
import com.example.tanveer.onetoonemapping.exception.InstructorNotFoundException;
import com.example.tanveer.onetoonemapping.model.CourseRequest;
import com.example.tanveer.onetoonemapping.model.InstructorDetailsRequest;
import com.example.tanveer.onetoonemapping.model.InstructorRequestToMany;
import com.example.tanveer.onetoonemapping.model.InstructorResponse;
import com.example.tanveer.onetoonemapping.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CourseService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public CourseService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;

    }

    public InstructorResponse createInstructor(InstructorRequestToMany instructorRequest) {

        InstructorEntity instructorEntity = modelToEntityCreate(instructorRequest);
        instructorRepository.save(instructorEntity);

        InstructorResponse response = new InstructorResponse();
        response.setId(instructorEntity.getId());
        log.info("Instructor is created with id {}:",instructorEntity.getId());
        return response;
    }

    public List<InstructorRequestToMany> getAll() {
        List<InstructorRequestToMany> requestToManyList = instructorRepository.findAll()
                .stream()
                .map(this::entityToModel)
                .toList();
        log.info("Retrieved Employee {}", requestToManyList.size());
        return requestToManyList;
    }

    public InstructorRequestToMany updateById(InstructorRequestToMany request, Long id) {
        Optional<InstructorEntity> optionalInstructorEntity = instructorRepository.findById(id);
        if (optionalInstructorEntity.isPresent()){
            log.info("update an instructor with id {} :",id);
            InstructorEntity entity = modelToEntityForUpdate(request);
            instructorRepository.save(entity);
            log.info("update an instructor with id {}",id);
        } else {
            log.error("Failed to retrieve Instructor with ID: {}", id);
            throw new InstructorNotFoundException("Instructor with id is not found :"+id);
        }
        return request;
    }


    public InstructorRequestToMany getById(Long id) {
        Optional<InstructorEntity> optionalInstructorEntity = instructorRepository.findById(id);
        if (optionalInstructorEntity.isPresent()){
            log.info("Retrieved Instructor with ID: {}", id);
            InstructorRequestToMany request = entityToModel(optionalInstructorEntity.get());
            return request;
        } else {
            log.error("Failed to retrieve Instructor with ID: {}", id);
            throw new InstructorNotFoundException("Instruction with id is not found :"+id);
        }
    }

//    public InstructorRequestToMany getById(Long id) {
//        Optional<InstructorEntity> optionalInstructorEntity = Optional.of(instructorRepository.getReferenceById(id));
//        log.info("Retrieved Instructor with ID: {}", id);
//        InstructorRequestToMany request = entityToModel(optionalInstructorEntity.get());
//        return request;
//    }

    private InstructorRequestToMany entityToModel(InstructorEntity instructorEntity) {
        InstructorRequestToMany instructorRequest = new InstructorRequestToMany();
        instructorRequest.setId(instructorEntity.getId());
        instructorRequest.setFirstName(instructorEntity.getFirstName());
        instructorRequest.setLastName(instructorEntity.getLastName());

        InstructorDetailsRequest instructorDetailsRequest = new InstructorDetailsRequest();
        instructorDetailsRequest.setId(instructorEntity.getInstructorDetails().getId());
        instructorDetailsRequest.setHobby(instructorEntity.getInstructorDetails().getHobby());
        instructorDetailsRequest.setYoutubeChannel(instructorEntity.getInstructorDetails().getYoutubeChannel());
        instructorRequest.setInstructorDetail(instructorDetailsRequest);

        List<CourseRequest> courseRequestsList = new ArrayList<>();

        for (CourseEntity entity : instructorEntity.getCourses()){
            CourseRequest courseRequest = new CourseRequest();
            courseRequest.setId(entity.getId());
            courseRequest.setTitle(entity.getTitleName());
            courseRequestsList.add(courseRequest);
        }
        instructorRequest.setCourses(courseRequestsList);
        return instructorRequest;
    }

    private InstructorEntity modelToEntityCreate(InstructorRequestToMany instructorRequest) {
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setFirstName(instructorRequest.getFirstName());
        instructorEntity.setLastName(instructorRequest.getLastName());

        InstructorDetailsEntity instructorDetailsEntity = new InstructorDetailsEntity();
        instructorDetailsEntity.setHobby(instructorRequest.getInstructorDetail().getHobby());
        instructorDetailsEntity.setYoutubeChannel(instructorRequest.getInstructorDetail().getYoutubeChannel());
        instructorEntity.setInstructorDetails(instructorDetailsEntity);

        List<CourseEntity> courseEntities = new ArrayList<>();
        for (CourseRequest course : instructorRequest.getCourses()){
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setTitleName(course.getTitle());
            courseEntity.setInstructor(instructorEntity);
            courseEntities.add(courseEntity);
        }
        instructorEntity.setCourses(courseEntities);
        return instructorEntity;
    }

    private InstructorEntity modelToEntityForUpdate(InstructorRequestToMany request) {
        InstructorEntity instructorEntity = new InstructorEntity();
//        instructorEntity.setId(id);
        instructorEntity.setId(request.getId());
        instructorEntity.setFirstName(request.getFirstName());
        instructorEntity.setLastName(request.getLastName());

        InstructorDetailsEntity instructorDetailsEntity = new InstructorDetailsEntity();
        instructorDetailsEntity.setId(request.getInstructorDetail().getId());
        instructorDetailsEntity.setHobby(request.getInstructorDetail().getHobby());
        instructorDetailsEntity.setYoutubeChannel(request.getInstructorDetail().getYoutubeChannel());
        instructorEntity.setInstructorDetails(instructorDetailsEntity);

        List<CourseEntity> courseEntities = new ArrayList<>();
        for (CourseRequest course : request.getCourses()){
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setId(course.getId());
            courseEntity.setTitleName(course.getTitle());
            courseEntity.setInstructor(instructorEntity);
            courseEntities.add(courseEntity);
        }
        instructorEntity.setCourses(courseEntities);
        return instructorEntity;
    }
}
