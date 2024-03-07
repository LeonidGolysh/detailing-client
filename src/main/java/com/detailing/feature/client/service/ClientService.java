package com.detailing.feature.client.service;

import com.detailing.feature.client.dto.CreateClientRequest;
import com.detailing.feature.client.dto.CreateClientResponse;
import com.detailing.feature.client.entity.Client;
import com.detailing.feature.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
