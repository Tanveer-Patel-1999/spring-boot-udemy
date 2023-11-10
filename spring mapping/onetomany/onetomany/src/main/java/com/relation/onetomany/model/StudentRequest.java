package com.relation.onetomany.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;


/**
 * A DTO for the {@link com.relation.onetomany.entity.StudentEntity} entity
 */
@Getter
@Setter
@ToString
public class StudentRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
}