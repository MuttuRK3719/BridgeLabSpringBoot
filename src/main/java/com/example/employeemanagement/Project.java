package com.example.employeemanagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    private int id;
    @Column(name = "project_name",nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private double budget;
}
