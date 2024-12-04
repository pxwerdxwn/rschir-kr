package com.rschir.db_admin.Entities;
import com.rschir.db_admin.DTO.DepartmentDTO;

import javax.persistence.*;

@Entity
@Table(name = "departments")  // Указываем таблицу, если имя таблицы отличается от имени класса
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Указываем стратегию генерации идентификатора
    @Column(name = "department_id")  // Указываем имя колонки, если оно отличается от имени поля
    private int departmentId;

    @Column(name = "name", nullable = false, length = 100)  // Указываем параметры для колонки
    private String name;

    @Column(name = "manager_id", nullable = false)
    private int managerId;

    // Геттеры и сеттеры
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

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
    // Переопределенный метод toString для отображения данных сущности
    public Department(DepartmentDTO departmentDTO) {

    }
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                '}';
    }

}


