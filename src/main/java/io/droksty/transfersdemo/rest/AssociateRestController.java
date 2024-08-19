package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;

import io.droksty.transfersdemo.service.AssociateService;
import io.droksty.transfersdemo.util.Mapper;
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
    public ResponseEntity<AssociateDTO> newAssociate(@RequestBody AssociateDTO associateDTO) {
        // Implement validation ?
        Associate insertedAssociate = service.insertAssociate(associateDTO);
        AssociateDTO insertedAssociateDTO = Mapper.newAssociateDTOFrom(insertedAssociate);
        return new ResponseEntity<>(insertedAssociateDTO, HttpStatus.CREATED);
    }

    /*@PostMapping("/bulk")
    public ResponseEntity<List<Associate>> insertAssociates(@RequestBody List<Associate> associates) {
        // Add validation
        var insertedAssociates = service.insertManyAssociates(associates);
        // Add DTO mapping
        return new ResponseEntity<>(insertedAssociates, HttpStatus.CREATED);
    }*/

    @GetMapping("")
    public ResponseEntity<List<Associate>> getAllAssociates() {
        var associates = service.getAllAssociates();
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }

}
