package com.example.tanveer.onetoonemapping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "instructor")
public class InstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details_id")
    private InstructorDetailsEntity instructorDetails;

    @OneToMany(mappedBy = "instructor", cascade = { CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
    private List<CourseEntity> courses;

    // methode for bidirectional relationship
    public void add(CourseEntity courseEntity){
        if (courses == null){
            courses = new ArrayList<>();
        }
        courses.add(courseEntity);
        courseEntity.setInstructor(this);
    }

}
