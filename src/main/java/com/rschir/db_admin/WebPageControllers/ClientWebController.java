package com.rschir.db_admin.WebPageControllers;

import com.rschir.db_admin.Repositories.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientWebController {

    private final ClientRepository clientRepository;

    public ClientWebController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public ModelAndView clientsPage() {
        ModelAndView modelAndView = new ModelAndView("clients");
        modelAndView.addObject("clients", clientRepository.findAll());
        return modelAndView;
    }
}
