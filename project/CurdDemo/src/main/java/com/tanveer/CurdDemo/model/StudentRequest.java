package com.tanveer.CurdDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentRequest  {
    private String firstName;
    private String lastName;
    private String email;
}
