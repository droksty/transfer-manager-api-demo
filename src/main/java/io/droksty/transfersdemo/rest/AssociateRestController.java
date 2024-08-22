package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;

import io.droksty.transfersdemo.service.AssociateService;
import io.droksty.transfersdemo.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
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


    // Endpoints
    @PostMapping("")
    public ResponseEntity<AssociateDTO> newAssociate(@RequestBody AssociateDTO associateDTO) {
        // Implement validation ?
        Associate insertedAssociate = service.insertAssociate(associateDTO);
        AssociateDTO insertedAssociateDTO = Mapper.newAssociateDTOFrom(insertedAssociate);
        return new ResponseEntity<>(insertedAssociateDTO, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<AssociateDTO> updateAssociate(@RequestBody AssociateDTO associateDTO) {
        // Implement validation ?
        Associate updatedAssociate = service.updateAssociate(associateDTO);
        AssociateDTO updateAssociateDTO = Mapper.newAssociateDTOFrom(updatedAssociate);
        return new ResponseEntity<>(updateAssociateDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssociate(@PathVariable("id") Long id) {
        if (id == null)
            throw new IllegalArgumentException("Error. Id cannot be null");
        if (!service.existsById(id))
            throw new EntityNotFoundException("Error. Associate wih Id:" + id + " does not exist.");
        service.deleteAssociate(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<AssociateDTO>> getAllAssociates() {
        List<Associate> associates = service.getAllAssociates();
        List<AssociateDTO> associatesDTO = Mapper.newAssociateDTOListFrom(associates);
        return new ResponseEntity<>(associatesDTO, HttpStatus.OK);
    }

}
