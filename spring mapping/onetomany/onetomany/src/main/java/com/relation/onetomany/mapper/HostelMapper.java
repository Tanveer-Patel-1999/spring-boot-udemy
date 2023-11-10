package com.relation.onetomany.mapper;

import com.relation.onetomany.entity.HostelEntity;
import com.relation.onetomany.entity.StudentEntity;
import com.relation.onetomany.model.HostelRequest;
import com.relation.onetomany.model.StudentRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper (unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HostelMapper {
    HostelEntity hotelRequestToHotelEntity ( HostelRequest hostelRequest );

    HostelRequest hotelEntityToHotelRequest (HostelEntity hostelEntity );

    StudentEntity studentToEntity(StudentRequest studentRequest);

    StudentRequest entityToStudent(StudentEntity studentEntity);

    List<StudentRequest> entityToStudents(List<StudentEntity> studentEntity);
    List<HostelRequest> hotelEntityToHotelRequests (List<HostelEntity> hostelEntity );


}