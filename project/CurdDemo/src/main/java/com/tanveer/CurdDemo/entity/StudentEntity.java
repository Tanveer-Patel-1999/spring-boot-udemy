package com.tanveer.CurdDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Student_table")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String email;
}
