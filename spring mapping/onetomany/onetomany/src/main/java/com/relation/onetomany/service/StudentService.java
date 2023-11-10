package com.relation.onetomany.service;

import com.relation.onetomany.entity.HostelEntity;
import com.relation.onetomany.entity.StudentEntity;
import com.relation.onetomany.mapper.HostelMapper;
import com.relation.onetomany.model.StudentRequest;
import com.relation.onetomany.model.StudentResponse;
import com.relation.onetomany.repository.HostelEntityRepository;
import com.relation.onetomany.repository.StudentEntityRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class StudentService {

    private final StudentEntityRepository studentEntityRepository;
    private final HostelEntityRepository hostelEntityRepository;
    private final HostelMapper hostelMapper;

    @Autowired
    public StudentService(StudentEntityRepository studentEntityRepository, HostelEntityRepository hostelEntityRepository, HostelMapper hostelMapper) {
        this.studentEntityRepository = studentEntityRepository;
        this.hostelEntityRepository = hostelEntityRepository;
        this.hostelMapper = hostelMapper;
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = hostelMapper.studentToEntity(studentRequest);
        studentEntityRepository.save(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        return studentResponse;
    }

    public List<StudentRequest> getAllStudents() {
        List<StudentEntity> allStudents = studentEntityRepository.findAll();
        return hostelMapper.entityToStudents(allStudents);
    }

    public StudentRequest getStudent(Long studentId) {
        StudentEntity studentEntity = studentEntityRepository.findById(studentId).get();
        return hostelMapper.entityToStudent(studentEntity);

    }

    public void assign(Long studentId, Long hostelId) {
        StudentEntity studentEntity = studentEntityRepository.findById(studentId).get();
        HostelEntity hostelEntity = hostelEntityRepository.findById(hostelId).get();
        log.info(hostelEntity);
        studentEntity.setHotel(hostelEntity);
        studentEntityRepository.save(studentEntity);
    }
}