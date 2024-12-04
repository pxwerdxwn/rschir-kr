package com.rschir.db_admin.EntityConverter;

import com.rschir.db_admin.DTO.ClientDTO;
import com.rschir.db_admin.Entities.Client;
import com.rschir.db_admin.Entities.Project;
import org.springframework.stereotype.Service;

@Service
public class ClientConverter implements EntityConverter<Client, ClientDTO> {

    @Override
    public ClientDTO convertToDTO(Client clientEntity) {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(clientEntity.getClientId());
        clientDTO.setName(clientEntity.getName());
        clientDTO.setContactEmail(clientEntity.getContactEmail());
        clientDTO.setPhoneNumber(clientEntity.getPhoneNumber());
        clientDTO.setProjectId(clientEntity.getProject() != null ? clientEntity.getProject().getProjectId() : 0);

        return clientDTO;
    }

    @Override
    public Client convertToEntity(ClientDTO clientDTO) {

        Client clientEntity = new Client();
        clientEntity.setName(clientDTO.getName());
        clientEntity.setContactEmail(clientDTO.getContactEmail());
        clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());

        // При необходимости можно задать проект, если он есть.
        if (clientDTO.getProjectId() != 0) {
            Project project = new Project();
            project.setProjectId(clientDTO.getProjectId());  // или получите проект из базы данных
            clientEntity.setProject(project);
        }

        return clientEntity;
    }
}
