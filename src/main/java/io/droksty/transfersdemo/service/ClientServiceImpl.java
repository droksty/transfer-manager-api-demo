package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Client;
import io.droksty.transfersdemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Section
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    // Section
    @Override
    public Client insertOneClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> insertManyClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

}
