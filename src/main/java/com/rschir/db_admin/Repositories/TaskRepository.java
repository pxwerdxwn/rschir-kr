package com.rschir.db_admin.Repositories;

import com.rschir.db_admin.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // Поиск задач по проекту
    List<Task> findByProject_ProjectId(int projectId);

    // Поиск задач по статусу
    List<Task> findByStatus(String status);

    // Поиск задач, назначенных на определенного сотрудника
    List<Task> findByAssignedTo_MemberId(int memberId);
}
