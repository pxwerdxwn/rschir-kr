package com.rschir.db_admin.RestControllers;

import com.rschir.db_admin.DTO.DepartmentDTO;
import com.rschir.db_admin.Entities.Department;
import com.rschir.db_admin.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/departments", produces = "application/json")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> allDepartmentsDTO = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartmentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/department/id/{departmentId}", produces = "application/json")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer departmentId) {
        Department departmentById = departmentService.findByDepartmentId(departmentId);
        if (departmentById != null) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No department with the id " + departmentId + " was found.");
        }
    }

    @PostMapping(value = "/add-new-department", consumes = "application/json")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.saveNewDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PutMapping(value = "/update-department/{departmentId}", consumes = "application/json")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Integer departmentId, @RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.findByDepartmentId(departmentId);
        if (department != null) {
            Department updatedDepartment = departmentService.updateDepartmentById(departmentId, departmentDTO);
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find department with the id: " + departmentId);
        }
    }

    @DeleteMapping("/department/{departmentId}")
    public void deleteDepartmentById(@PathVariable Integer departmentId) {
        if (departmentService.isDepartmentIdPresent(departmentId)) {
            departmentService.deleteDepartmentById(departmentId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No department with the id " + departmentId + " was found.");
        }
    }
}
