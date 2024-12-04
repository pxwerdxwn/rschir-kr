package com.rschir.db_admin.Services;

import com.rschir.db_admin.DTO.ClientDTO;
import com.rschir.db_admin.Entities.Client;
import com.rschir.db_admin.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public Boolean isClientIdPresent(Integer id) {
        return clientRepository.findById(id).isPresent();
    }

    @Transactional
    public Client findByClientId(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new RuntimeException("Невозможно найти клиента с ID: " + id);
        }
    }

    @Transactional
    public List<ClientDTO> getAllClients() {
        List<Client> allClients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();

        for (Client client : allClients) {
            ClientDTO dto = new ClientDTO(client);
            clientDTOS.add(dto);
        }
        return clientDTOS;
    }

    @Transactional
    public Client saveNewClient(ClientDTO clientDTO) {
        Client client = new Client();
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClientById(Integer id, ClientDTO clientDTO) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) {
            throw new RuntimeException("Could not find client with the id: " + id);
        }

        Client client = optionalClient.get();
        client.setName(clientDTO.getName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }
}
