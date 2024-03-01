package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.service.TransferService;
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


    // Section
    @PostMapping("")
    public ResponseEntity<Transfer> insertTransfer(@RequestBody Transfer transfer) {
        // Add validation
        var insertedTransfer = service.insertOneTransfer(transfer);
        // Add DTO mapping
        return new ResponseEntity<>(insertedTransfer, HttpStatus.CREATED);
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
    public ResponseEntity<String> deleteTransfer(@PathVariable("id")Integer id) {
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
}
