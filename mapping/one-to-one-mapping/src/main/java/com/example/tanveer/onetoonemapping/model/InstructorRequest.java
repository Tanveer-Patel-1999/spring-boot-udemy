package com.example.tanveer.onetoonemapping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InstructorRequest extends InstructorResponse{

    private String firstName;
    private String lastName;
    private InstructorDetailsRequest instructorDetail;
}
