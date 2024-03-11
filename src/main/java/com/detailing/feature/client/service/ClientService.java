package com.detailing.feature.client.service;

import com.detailing.feature.client.dto.create.CreateClientRequest;
import com.detailing.feature.client.dto.create.CreateClientResponse;
import com.detailing.feature.client.entity.Client;
import com.detailing.feature.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public CreateClientResponse createClient(CreateClientRequest request) {
        Client client = new Client();

        client.setName(request.getName());
        client.setPhoneNumber(request.getPhone());

        clientRepository.save(client);

        CreateClientResponse response = new CreateClientResponse();
        response.setClientId(client.getId());

        return response;
    }

    public void updateClient(UUID id, String newName, String newPhoneNumber) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            if (newName != null) {
                client.setName(newName);
            }
            if (newPhoneNumber != null) {
                client.setPhoneNumber(newPhoneNumber);
            }
            clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("Record with ID " + id + " not found");
        }
    }

    public void deleteClient(UUID clientId) {
        clientRepository.deleteById(clientId);
    }
}
