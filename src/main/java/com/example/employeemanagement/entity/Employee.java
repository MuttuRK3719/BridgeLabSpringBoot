package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_seq",
            allocationSize = 1
    )
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String department;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public void addProject(Project p) {
        projects.add(p);
        p.getEmployees().add(this);
    }

    public void removeProject(Project p) {
        projects.remove(p);
        p.getEmployees().remove(this);
    }
}
