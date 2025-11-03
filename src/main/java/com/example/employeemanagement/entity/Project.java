package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Project {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "project_sequence_no")
    @SequenceGenerator(
            name = "project_sequence_no",
            sequenceName="project_sequence",
            allocationSize = 1
    )
    @Id
    private Long id;

    @Column(name = "project_name",nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private double budget;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;
}
