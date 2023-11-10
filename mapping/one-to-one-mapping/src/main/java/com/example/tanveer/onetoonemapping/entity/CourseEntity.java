package com.example.tanveer.onetoonemapping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_name")
    private String titleName;

    @ManyToOne(fetch = FetchType.LAZY ,  cascade = { CascadeType.PERSIST , CascadeType.MERGE ,
                            CascadeType.DETACH , CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;
}
