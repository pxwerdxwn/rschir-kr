package com.rschir.db_admin.DTO;


import com.rschir.db_admin.Entities.Client;

public class ClientDTO {

    private int clientId;
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private int projectId;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.clientId = client.getClientId();
        this.name = client.getName();
        this.contactEmail = client.getContactEmail();
        this.phoneNumber = client.getPhoneNumber();
        this.projectId = client.getProject() != null ? client.getProject().getProjectId() : 0;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}

