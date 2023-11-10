package com.relation.onetomany.model;

import com.relation.onetomany.entity.HostelEntity;
import com.relation.onetomany.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * A DTO for the {@link HostelEntity} entity
 */
@Getter
@Setter
public class HostelRequest extends HostelResponse{
    private String hostelName;
    private List<StudentEntity> students;
}