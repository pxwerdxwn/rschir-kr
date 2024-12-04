package com.rschir.db_admin.EntityConverter;


import com.rschir.db_admin.DTO.DepartmentDTO;
import com.rschir.db_admin.Entities.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentConverter implements EntityConverter<Department, DepartmentDTO> {

    @Override
    public DepartmentDTO convertToDTO(Department departmentEntity) {

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(departmentEntity.getName());
        departmentDTO.setManagerId(departmentEntity.getManagerId());

        return departmentDTO;
    }

    @Override
    public Department convertToEntity(DepartmentDTO departmentDTO) {

        Department departmentEntity = new Department(departmentDTO);
        departmentEntity.setName(departmentDTO.getName());
        departmentEntity.setManagerId(departmentDTO.getManagerId());

        return departmentEntity;
    }
}

