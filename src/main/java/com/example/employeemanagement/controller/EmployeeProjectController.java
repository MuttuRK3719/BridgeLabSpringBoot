package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.dto.ProjectDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.ProjectService;
import com.example.employeemanagement.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeProjectController {
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public EmployeeProjectController(EmployeeService employeeService,
                                     ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    public ResponseEntity<ProjectDTO> addProject( @RequestBody ProjectDTO dto) {
        Project p = projectService.createProject(dto);
        return ResponseEntity.ok(MapperUtil.toProjectDTO(p));
    }

    /**
     *
     * @param employeeId
     * @param projectId
     * @return
     */
    @PostMapping("/employees/{employeeId}/projects/{projectId}")
    public ResponseEntity<EmployeeDTO> assignEmployeeToProject(
            @PathVariable Long employeeId,
            @PathVariable Long projectId){
        Employee updated = employeeService.assignEmployeeToProject(employeeId, projectId);
        return ResponseEntity.ok(MapperUtil.toEmployeeDTO(updated));
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeWithProjects(@PathVariable Long id) {
        Employee e = employeeService.getEmployeeWithProjects(id);
        return ResponseEntity.ok(MapperUtil.toEmployeeDTO(e));
    }
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> list = projectService.getAllProjects()
                .stream()
                .map(MapperUtil::toProjectDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
