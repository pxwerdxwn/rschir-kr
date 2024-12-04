package com.rschir.db_admin.Entities;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    // Конструкторы, геттеры и сеттеры
    public Client() {
    }

    public Client(String name, String contactEmail, String phoneNumber, Project project) {
        this.name = name;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.project = project;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", project=" + project +
                '}';
    }
}
