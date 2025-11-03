package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Employee createEmployee(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        try {
            return employeeRepository.save(e);
        } catch (DataIntegrityViolationException ex) {
            // propagate for global handler to format
            throw ex;
        }
    }
    @Transactional(readOnly = true)
    public Employee getEmployeeWithProjects(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
    }

    @Transactional
    public Employee assignEmployeeToProject(Long employeeId, Long projectId) {
        Employee emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
        emp.addProject(project);
        return employeeRepository.save(emp);
    }

}
