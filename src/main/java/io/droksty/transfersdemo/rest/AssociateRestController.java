package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.model.Associate;

import io.droksty.transfersdemo.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/associates")
public class AssociateRestController {

    // Section
    private final AssociateService service;

    @Autowired
    AssociateRestController(AssociateService service) {
        this.service = service;
    }


    // Section
    @PostMapping("")
    public ResponseEntity<Associate> insertAssociate(@RequestBody Associate associate) {
        // Add validation
        var insertedAssociate = service.insertOneAssociate(associate);
        // Add DTO mapping
        return new ResponseEntity<>(insertedAssociate, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Associate>> insertAssociates(@RequestBody List<Associate> associates) {
        // Add validation
        var insertedAssociates = service.insertManyAssociates(associates);
        // Add DTO mapping
        return new ResponseEntity<>(insertedAssociates, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Associate>> getAllAssociates() {
        var associates = service.getAllAssociates();
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }

}
