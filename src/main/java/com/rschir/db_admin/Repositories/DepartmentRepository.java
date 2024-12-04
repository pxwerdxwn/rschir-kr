package com.rschir.db_admin.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rschir.db_admin.Entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
