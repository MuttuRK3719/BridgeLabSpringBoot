package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.ProjectDTO;
import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.exception.ProjectAssignedException;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.ProjectRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Transactional
    public Project createProject(ProjectDTO dto) {
        Project p = new Project();
        p.setName(dto.getName());
        p.setBudget(dto.getBudget());
        try {
            return projectRepository.save(p);
        } catch (DataIntegrityViolationException ex) {
            throw ex;
        }
    }
    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    @Transactional
    public void deleteProject(Long projectId) {
        Project p = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
        if (p.getEmployees() != null && !p.getEmployees().isEmpty()) {
            throw new ProjectAssignedException("Cannot delete project. Project is assigned to employees.");
        }
        projectRepository.delete(p);
    }
}
