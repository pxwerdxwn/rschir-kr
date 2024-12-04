package com.rschir.db_admin.Services;

import com.rschir.db_admin.DTO.TaskDTO;
import com.rschir.db_admin.Entities.Task;
import com.rschir.db_admin.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Transactional
    public Boolean isTaskIdPresent(Integer id) {
        return taskRepository.findById(id).isPresent();
    }

    @Transactional
    public Task findByTaskId(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new RuntimeException("Could not find a task with the id: " + id);
        }
    }

    @Transactional
    public List<TaskDTO> getAllTasks() {
        List<Task> allTasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = new ArrayList<>();

        for (Task task : allTasks) {
            TaskDTO dto = new TaskDTO(task);
            taskDTOS.add(dto);
        }
        return taskDTOS;
    }

    @Transactional
    public Task saveNewTask(TaskDTO taskDTO) {
        Task task = new Task();
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTaskById(Integer id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            throw new RuntimeException("Could not find task with the id: " + id);
        }

        Task task = optionalTask.get();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());

        task.setStatus(taskDTO.getStatus());
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }
}
