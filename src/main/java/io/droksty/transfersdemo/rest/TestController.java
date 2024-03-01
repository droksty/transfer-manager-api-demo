package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.service.ClientService;
import io.droksty.transfersdemo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    // Section
    private final ClientService clientService;
    private final TransferService transferService;

    @Autowired
    TestController(ClientService clientService, TransferService transferService) {
        this.clientService = clientService;
        this.transferService = transferService;
    }


    // Section

}
