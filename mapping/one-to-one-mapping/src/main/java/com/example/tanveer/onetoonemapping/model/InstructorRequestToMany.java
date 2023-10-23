package com.example.tanveer.onetoonemapping.model;

import lombok.Data;

import java.util.List;

@Data
public class InstructorRequestToMany extends InstructorResponse {
    private String firstName;
    private String lastName;
    private InstructorDetailsRequest instructorDetail;
    private List<CourseRequest> courses;
}
