package com.rschir.db_admin.Entities;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private int documentId;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
    private Project project;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "uploaded_by", referencedColumnName = "member_id")
    private TeamMembers uploadedBy;

    // Конструкторы, геттеры и сеттеры
    public Document() {
    }

    public Document(Project project, String name, String fileUrl, TeamMembers uploadedBy) {
        this.project = project;
        this.name = name;
        this.fileUrl = fileUrl;
        this.uploadedBy = uploadedBy;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public TeamMembers getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(TeamMembers uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", project=" + project +
                ", name='" + name + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadedBy=" + uploadedBy +
                '}';
    }
}
