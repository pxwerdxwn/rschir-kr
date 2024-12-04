package com.rschir.db_admin.Services;

import com.rschir.db_admin.DTO.DocumentDTO;
import com.rschir.db_admin.Entities.Document;
import com.rschir.db_admin.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Transactional
    public Boolean isDocumentIdPresent(Integer id) {
        return documentRepository.findById(id).isPresent();
    }

    @Transactional
    public Document findByDocumentId(Integer id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            return document.get();
        } else {
            throw new RuntimeException("Could not find a document with the id: " + id);
        }
    }

    @Transactional
    public List<DocumentDTO> getAllDocuments() {
        List<Document> allDocuments = documentRepository.findAll();
        List<DocumentDTO> documentDTOS = new ArrayList<>();

        for (Document document : allDocuments) {
            DocumentDTO dto = new DocumentDTO(document);
            documentDTOS.add(dto);
        }
        return documentDTOS;
    }

    @Transactional
    public Document saveNewDocument(DocumentDTO documentDTO) {
        Document document = new Document();
        return documentRepository.save(document);
    }

    @Transactional
    public Document updateDocumentById(Integer id, DocumentDTO documentDTO) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (!optionalDocument.isPresent()) {
            throw new RuntimeException("Could not find document with the id: " + id);
        }

        Document document = optionalDocument.get();
        document.setName(documentDTO.getName());
        document.setFileUrl(documentDTO.getFileUrl());
        document.setFileUrl(documentDTO.getFileUrl());
        return documentRepository.save(document);
    }

    @Transactional
    public void deleteDocumentById(Integer id) {
        documentRepository.deleteById(id);
    }
}
