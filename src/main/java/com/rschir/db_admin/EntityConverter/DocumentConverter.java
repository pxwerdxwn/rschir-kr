package com.rschir.db_admin.EntityConverter;

import com.rschir.db_admin.DTO.DocumentDTO;
import com.rschir.db_admin.Entities.Document;
import com.rschir.db_admin.Entities.Project;
import com.rschir.db_admin.Entities.TeamMembers;
import org.springframework.stereotype.Service;

@Service
public class DocumentConverter implements EntityConverter<Document, DocumentDTO> {

    @Override
    public DocumentDTO convertToDTO(Document documentEntity) {

        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDocumentId(documentEntity.getDocumentId());
        documentDTO.setName(documentEntity.getName());
        documentDTO.setFileUrl(documentEntity.getFileUrl());
        documentDTO.setProjectId(documentEntity.getProject() != null ? documentEntity.getProject().getProjectId() : 0);
        documentDTO.setUploadedById(documentEntity.getUploadedBy() != null ? documentEntity.getUploadedBy().getMemberId() : 0);

        if (documentEntity.getUploadedBy() != null) {
            documentDTO.setUploadedByName(documentEntity.getUploadedBy().getFirstName() + " " + documentEntity.getUploadedBy().getLastName());
        }

        return documentDTO;
    }

    @Override
    public Document convertToEntity(DocumentDTO documentDTO) {

        Document documentEntity = new Document();
        documentEntity.setName(documentDTO.getName());
        documentEntity.setFileUrl(documentDTO.getFileUrl());

        // Получение проекта и участника команды (если необходимо)
        Project project = new Project();
        project.setProjectId(documentDTO.getProjectId());  // Получите проект из базы данных по ID
        documentEntity.setProject(project);

        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setMemberId(documentDTO.getUploadedById());  // Получите участника команды из базы данных по ID
        documentEntity.setUploadedBy(teamMembers);

        return documentEntity;
    }
}
