package com.relation.onetomany.service;

import com.relation.onetomany.entity.HostelEntity;
import com.relation.onetomany.entity.StudentEntity;
import com.relation.onetomany.mapper.HostelMapper;
import com.relation.onetomany.model.HostelRequest;
import com.relation.onetomany.model.HostelResponse;
import com.relation.onetomany.repository.HostelEntityRepository;
import com.relation.onetomany.repository.StudentEntityRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class HostelService {
    private final HostelEntityRepository hostelEntityRepository;
    private final StudentEntityRepository studentEntityRepository;

    private final HostelMapper hostelMapper;

    @Autowired
    public HostelService(HostelEntityRepository hostelEntityRepository, StudentEntityRepository studentEntityRepository, HostelMapper hostelMapper) {
        this.hostelEntityRepository = hostelEntityRepository;
        this.studentEntityRepository = studentEntityRepository;
        this.hostelMapper = hostelMapper;
    }

    public HostelResponse create(HostelRequest hostelRequest) {
        HostelEntity hostelEntity = hostelMapper.hotelRequestToHotelEntity(hostelRequest);
        HostelEntity save = hostelEntityRepository.save(hostelEntity);

        HostelResponse hostelResponse = new HostelResponse();
        hostelResponse.setId(save.getId());
        return hostelResponse;
    }

    public HostelRequest getHostel(Long hostelId) {
        HostelRequest hostelRequest  = new HostelRequest();
        Optional<HostelEntity> hostelEntity = hostelEntityRepository.findById(hostelId);
        if (hostelEntity.isPresent()){
            hostelRequest =  hostelMapper.hotelEntityToHotelRequest(hostelEntity.get());
        }
        return hostelRequest ;
    }

    public List<HostelRequest> getAllHostel() {
        List<HostelEntity> all = hostelEntityRepository.findAll();
        return hostelMapper.hotelEntityToHotelRequests(all);
    }

    public HostelRequest updateHostel(Long hostelId, HostelRequest hostelRequest) {
        hostelEntityRepository.findById(hostelId);
        HostelEntity hostelEntity1 = hostelMapper.hotelRequestToHotelEntity(hostelRequest);
        hostelEntity1.setId(hostelId);
        HostelEntity save = hostelEntityRepository.save(hostelEntity1);
        return hostelMapper.hotelEntityToHotelRequest(save);


    }

    public void deleteHostel(Long hostelId) {
        Optional<HostelEntity> hostel = hostelEntityRepository.findById(hostelId);
        if (hostel.isPresent()) {
            hostelEntityRepository.deleteById(hostelId);
        }
    }

    public HostelEntity assignment(Long hostelId, Long studentId) {
        HostelEntity hostelEntity = hostelEntityRepository.findById(hostelId).get();
        StudentEntity studentEntity = studentEntityRepository.findById(studentId).get();
        studentEntity.setHotel(hostelEntity);
        List<StudentEntity> students = hostelEntity.getStudents();
        students.add(studentEntity);
        hostelEntity.setStudents(students);
        log.info(students);
        HostelEntity save = hostelEntityRepository.save(hostelEntity);
        log.info(save);

        return hostelEntity ;

    }


}