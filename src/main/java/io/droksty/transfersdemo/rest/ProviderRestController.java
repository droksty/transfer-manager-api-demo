package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.model.Provider;
import io.droksty.transfersdemo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/providers")
public class ProviderRestController {

    // Section
    private final ProviderService service;

    @Autowired
    ProviderRestController(ProviderService service) {
        this.service = service;
    }


    // Section
    @PostMapping("")
    public ResponseEntity<List<Provider>> insertProviders(@RequestBody List<Provider> providers) {
        // Add validation
        var insertedProviders = service.insertManyProviders(providers);
        // Add DTO mapping
        return new ResponseEntity<>(insertedProviders, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Provider>> getAllProviders() {
        var providers = service.getAllProviders();
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }
}
