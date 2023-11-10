package com.relation.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "hotel")
public class HostelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String hostelName ;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEntity> students ;

}