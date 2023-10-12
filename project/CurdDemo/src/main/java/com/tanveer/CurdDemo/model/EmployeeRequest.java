package com.tanveer.CurdDemo.model;

import lombok.Data;

@Data
public class EmployeeRequest extends EmployeeResponse{
    private String firstName;
    private String lastName;
    private String email;
}
