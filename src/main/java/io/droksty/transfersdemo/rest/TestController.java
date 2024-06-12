package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.service.AssociateService;
import io.droksty.transfersdemo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    // Section
    private final AssociateService associateService;
    private final TransferService transferService;

    @Autowired
    TestController(AssociateService associateService, TransferService transferService) {
        this.associateService = associateService;
        this.transferService = transferService;
    }


    // Section

}
