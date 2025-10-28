package com.example.employeemanagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_seq",
            allocationSize = 1
    )

    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String dept;
}
