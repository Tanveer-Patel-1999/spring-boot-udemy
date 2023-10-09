package com.tanveer.CurdDemo.model;

import lombok.Data;

@Data
public class StudentRequest extends StudentResponse {
    private String firstName;
    private String lastName;
    private String email;


}
