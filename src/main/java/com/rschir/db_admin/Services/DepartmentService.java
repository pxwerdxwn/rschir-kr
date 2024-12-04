package com.rschir.db_admin.Services;

import com.rschir.db_admin.DTO.DepartmentDTO;
import com.rschir.db_admin.Entities.Department;
import com.rschir.db_admin.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    public Boolean isDepartmentIdPresent(Integer id) {
        return departmentRepository.findById(id).isPresent();
    }

    @Transactional
    public Department findByDepartmentId(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new RuntimeException("Could not find a department with the id: " + id);
        }
    }

    @Transactional
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for (Department department : allDepartments) {
            DepartmentDTO dto = new DepartmentDTO();
            departmentDTOS.add(dto);
        }
        return departmentDTOS;
    }

    @Transactional
    public Department saveNewDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(departmentDTO);
        return departmentRepository.save(department);
    }

    @Transactional
    public Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent()) {
            throw new RuntimeException("Could not find department with the id: " + id);
        }

        Department department = optionalDepartment.get();
        department.setName(departmentDTO.getName());
        return departmentRepository.save(department);
    }

    @Transactional
    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
