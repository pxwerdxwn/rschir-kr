package com.rschir.db_admin.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "member_id")
    private TeamMembers assignedTo;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
    private Project project;

    @Column(name = "status", nullable = false)
    private String status;

    // Конструкторы, геттеры и сеттеры
    public Task() {
    }

    public Task(String name, String description, TeamMembers assignedTo, Project project, String status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.project = project;
        this.status = status;
    }

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

    public TeamMembers getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(TeamMembers assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo=" + assignedTo +
                ", project=" + project +
                ", status='" + status + '\'' +
                '}';
    }
}
