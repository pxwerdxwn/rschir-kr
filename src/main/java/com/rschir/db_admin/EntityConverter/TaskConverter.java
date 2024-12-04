package com.rschir.db_admin.EntityConverter;

import com.rschir.db_admin.DTO.TaskDTO;
import com.rschir.db_admin.Entities.Task;
import com.rschir.db_admin.Entities.Project;
import com.rschir.db_admin.Entities.TeamMembers;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter implements EntityConverter<Task, TaskDTO> {

    @Override
    public TaskDTO convertToDTO(Task taskEntity) {
        return new TaskDTO(taskEntity);
    }

    @Override
    public Task convertToEntity(TaskDTO taskDTO) {
        Task taskEntity = new Task();

        taskEntity.setName(taskDTO.getName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setStatus(taskDTO.getStatus());

        // Связываем проект
        Project project = new Project();
        project.setProjectId(taskDTO.getProjectId());
        taskEntity.setProject(project);

        // Связываем сотрудника
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setMemberId(taskDTO.getAssignedToId());
        taskEntity.setAssignedTo(teamMembers);

        return taskEntity;
    }
}
