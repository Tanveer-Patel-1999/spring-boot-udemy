package com.example.tanveer.onetoonemapping.mapper;

import com.example.tanveer.onetoonemapping.entity.InstructorEntity;
import com.example.tanveer.onetoonemapping.model.InstructorRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorEntity modelToEntity(InstructorRequest instructorRequest);

    InstructorRequest entityToModel(InstructorEntity instructorEntity);

    List<InstructorRequest> entityToModels(List<InstructorEntity> instructorEntities);
}
