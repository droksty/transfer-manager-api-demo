package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Client;

import java.util.List;

public interface ClientService {
    Client insertOneClient(Client client);
    List<Client> insertManyClients(List<Client> clients);
}
