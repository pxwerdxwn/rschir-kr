package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.DocumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DocumentWebController {

    private final DocumentRepository documentRepository;

    public DocumentWebController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/documents")
    public ModelAndView documentsPage() {
        ModelAndView modelAndView = new ModelAndView("documents");
        modelAndView.addObject("documents", documentRepository.findAll());
        return modelAndView;
    }
}
