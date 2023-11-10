package com.relation.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity

@Table (name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String gender ;
    private String dob;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HostelEntity hotel ;
}