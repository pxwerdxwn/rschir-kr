package com.rschir.db_admin.RestControllers;


import com.rschir.db_admin.DTO.TaskDTO;
import com.rschir.db_admin.Entities.Task;
import com.rschir.db_admin.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/tasks", produces = "application/json")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> allTasksDTO = taskService.getAllTasks();
        return new ResponseEntity<>(allTasksDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/task/id/{taskId}", produces = "application/json")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer taskId) {
        Task taskById = taskService.findByTaskId(taskId);
        if (taskById != null) {
            TaskDTO taskDTO = new TaskDTO(taskById);
            return new ResponseEntity<>(taskDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No task with the id " + taskId + " was found.");
        }
    }

    @PostMapping(value = "/add-new-task", consumes = "application/json")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.saveNewTask(taskDTO);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping(value = "/update-task/{taskId}", consumes = "application/json")
    public ResponseEntity<Task> updateTaskById(@PathVariable Integer taskId, @RequestBody TaskDTO taskDTO) {
        Task task = taskService.findByTaskId(taskId);
        if (task != null) {
            Task updatedTask = taskService.updateTaskById(taskId, taskDTO);
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find task with the id: " + taskId);
        }
    }

    @DeleteMapping("/task/{taskId}")
    public void deleteTaskById(@PathVariable Integer taskId) {
        if (taskService.isTaskIdPresent(taskId)) {
            taskService.deleteTaskById(taskId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No task with the id " + taskId + " was found.");
        }
    }
}
