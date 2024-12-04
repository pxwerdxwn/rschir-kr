package com.rschir.db_admin.RestControllers;

import com.rschir.db_admin.DTO.ClientDTO;
import com.rschir.db_admin.Entities.Client;
import com.rschir.db_admin.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients", produces = "application/json")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> allClientsDTO = clientService.getAllClients();
        return new ResponseEntity<>(allClientsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/client/id/{clientId}", produces = "application/json")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Integer clientId) {
        Client clientById = clientService.findByClientId(clientId);
        if (clientById != null) {
            ClientDTO clientDTO = new ClientDTO(clientById);
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No client with the id " + clientId + " was found.");
        }
    }

    @PostMapping(value = "/add-new-client", consumes = "application/json")
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.saveNewClient(clientDTO);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping(value = "/update-client/{clientId}", consumes = "application/json")
    public ResponseEntity<Client> updateClientById(@PathVariable Integer clientId, @RequestBody ClientDTO clientDTO) {
        Client client = clientService.findByClientId(clientId);
        if (client != null) {
            Client updatedClient = clientService.updateClientById(clientId, clientDTO);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find client with the id: " + clientId);
        }
    }

    @DeleteMapping("/client/{clientId}")
    public void deleteClientById(@PathVariable Integer clientId) {
        if (clientService.isClientIdPresent(clientId)) {
            clientService.deleteClientById(clientId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No client with the id " + clientId + " was found.");
        }
    }
}
