package com.rschir.db_admin.DTO;

import com.rschir.db_admin.Entities.Task;

public class TaskDTO {

    private int taskId;
    private String name;
    private String description;
    private String status;
    private int projectId;
    private String projectName;
    private int assignedToId;
    private String assignedToName;

    public TaskDTO() {
    }

    public TaskDTO(Task task) {
        this.taskId = task.getTaskId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.projectId = task.getProject() != null ? task.getProject().getProjectId() : 0;
        this.projectName = task.getProject() != null ? task.getProject().getName() : null;
        this.assignedToId = task.getAssignedTo() != null ? task.getAssignedTo().getMemberId() : 0;
        this.assignedToName = task.getAssignedTo() != null ? task.getAssignedTo().getFirstName() + " " + task.getAssignedTo().getLastName() : null;
    }

    // Геттеры и сеттеры
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(int assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", assignedToId=" + assignedToId +
                ", assignedToName='" + assignedToName + '\'' +
                '}';
    }
}
