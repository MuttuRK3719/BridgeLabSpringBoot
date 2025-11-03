package com.example.employeemanagement.util;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.dto.ProjectDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.Project;

public class MapperUtil {
    public static EmployeeDTO toEmployeeDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setDepartment(e.getDepartment());
        return dto;
    }

    public static ProjectDTO toProjectDTO(Project p) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setBudget(p.getBudget());
        return dto;
    }
}
