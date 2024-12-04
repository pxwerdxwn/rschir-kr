package com.rschir.db_admin.DTO;

import com.rschir.db_admin.Entities.Document;

public class DocumentDTO {

    private int documentId;
    private int projectId;
    private String name;
    private String fileUrl;
    private int uploadedById;
    private String uploadedByName;

    public DocumentDTO() {
    }

    public DocumentDTO(Document document) {
        this.documentId = document.getDocumentId();
        this.projectId = document.getProject() != null ? document.getProject().getProjectId() : 0;
        this.name = document.getName();
        this.fileUrl = document.getFileUrl();
        this.uploadedById = document.getUploadedBy() != null ? document.getUploadedBy().getMemberId() : 0;
        this.uploadedByName = document.getUploadedBy() != null ? document.getUploadedBy().getFirstName() + " " + document.getUploadedBy().getLastName() : null;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getUploadedById() {
        return uploadedById;
    }

    public void setUploadedById(int uploadedById) {
        this.uploadedById = uploadedById;
    }

    public String getUploadedByName() {
        return uploadedByName;
    }

    public void setUploadedByName(String uploadedByName) {
        this.uploadedByName = uploadedByName;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "documentId=" + documentId +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadedById=" + uploadedById +
                ", uploadedByName='" + uploadedByName + '\'' +
                '}';
    }
}
