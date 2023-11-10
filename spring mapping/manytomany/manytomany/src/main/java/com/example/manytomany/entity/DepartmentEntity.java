package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "select")
public class DepartmentEntity {
    @Id
    @SequenceGenerator(name = "seq_dept_id", initialValue = 1, sequenceName = "seq_dept_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dept_id")
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "department")
    private Set<EmployeeEntity> Employee;
}
