package com.rschir.db_admin.DTO;


public class DepartmentDTO {

    private String name;
    private int managerId;

    // Конструктор
    public DepartmentDTO() {
    }

    // Конструктор с параметрами
    public DepartmentDTO(String name, int managerId) {
        this.name = name;
        this.managerId = managerId;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                ", managerId=" + managerId +
                '}';
    }

}
