package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.model.Client;
import io.droksty.transfersdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientRestController {

    // Section
    private final ClientService service;

    @Autowired ClientRestController(ClientService service) {
        this.service = service;
    }


    // Section
    @PostMapping("")
    public ResponseEntity<Client> insertClient(@RequestBody Client client) {
        // Add validation
        var insertedClient = service.insertOneClient(client);
        // Add DTO mapping
        return new ResponseEntity<>(insertedClient, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Client>> insertClients(@RequestBody List<Client> clients) {
        // Add validation
        var insertedClients = service.insertManyClients(clients);
        // Add DTO mapping
        return new ResponseEntity<>(insertedClients, HttpStatus.CREATED);
    }
}
