package com.rschir.db_admin.RestControllers;

import com.rschir.db_admin.DTO.DocumentDTO;
import com.rschir.db_admin.Entities.Document;
import com.rschir.db_admin.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = "/documents", produces = "application/json")
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
        List<DocumentDTO> allDocumentsDTO = documentService.getAllDocuments();
        return new ResponseEntity<>(allDocumentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/document/id/{documentId}", produces = "application/json")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Integer documentId) {
        Document documentById = documentService.findByDocumentId(documentId);
        if (documentById != null) {
            DocumentDTO documentDTO = new DocumentDTO(documentById);
            return new ResponseEntity<>(documentDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No document with the id " + documentId + " was found.");
        }
    }

    @PostMapping(value = "/add-new-document", consumes = "application/json")
    public ResponseEntity<Document> createDocument(@RequestBody DocumentDTO documentDTO) {
        Document document = documentService.saveNewDocument(documentDTO);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PutMapping(value = "/update-document/{documentId}", consumes = "application/json")
    public ResponseEntity<Document> updateDocumentById(@PathVariable Integer documentId, @RequestBody DocumentDTO documentDTO) {
        Document document = documentService.findByDocumentId(documentId);
        if (document != null) {
            Document updatedDocument = documentService.updateDocumentById(documentId, documentDTO);
            return new ResponseEntity<>(updatedDocument, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find document with the id: " + documentId);
        }
    }

    @DeleteMapping("/document/{documentId}")
    public void deleteDocumentById(@PathVariable Integer documentId) {
        if (documentService.isDocumentIdPresent(documentId)) {
            documentService.deleteDocumentById(documentId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No document with the id " + documentId + " was found.");
        }
    }
}
