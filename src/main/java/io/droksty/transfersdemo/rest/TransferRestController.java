package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.service.TransferService;
import io.droksty.transfersdemo.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transfers")
public class TransferRestController {

    // Section
    private final TransferService service;

    @Autowired
    public TransferRestController(TransferService service) {
        this.service = service;
    }


    // Endpoints
    @PostMapping("")
    public ResponseEntity<TransferDTO> newTransfer(@RequestBody TransferDTO transferDTO) {
        // Implement validation ?
        System.out.println(transferDTO);
        Transfer insertedTransfer = service.insertOneTransfer(transferDTO);
        System.out.println(insertedTransfer);
        TransferDTO insertedTransferDTO = Mapper.newTransferDTOFrom(insertedTransfer);
        return new ResponseEntity<>(insertedTransferDTO, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Transfer>> insertTransfers(@RequestBody List<Transfer> transfers) {
        // Add validation
        var insertedTransfers = service.insertManyTransfers(transfers);
        // Add DTO mapping
        return new ResponseEntity<>(insertedTransfers, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Transfer> updateTransfer(@RequestBody Transfer transfer) {
        // Add validation
        var updated = service.updateOneTransfer(transfer);
        // Add DTO mapping
        return new ResponseEntity<>(updated, HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable("id")Long id) {
        if (id == null) throw new IllegalArgumentException("Error. Id cannot be null.");
        if (!service.existsById(id)) throw new EntityNotFoundException("Error. Transfer with id: " + id + " does not exist.");

        service.deleteOneTransfer(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Transfer>> getTransfersByDate(@RequestParam LocalDate date) {
        var transfers = service.getTransfersByDate(date);
        // Add DTO mapping
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }


    @GetMapping("dates-between")
    public ResponseEntity<List<Transfer>> getTransfersByDatesBetween(@RequestParam LocalDate from, LocalDate to) {
        var transfers = service.getTransfersByDatesBetween(from, to);
        // Add DTO mapping
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }
}
