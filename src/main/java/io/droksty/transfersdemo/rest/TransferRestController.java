package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.dto.TransferListView;
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
    public ResponseEntity<List<TransferDTO>> newTransfers(@RequestBody List<TransferDTO> transferDTOs) {
        // Implement validation ?
        System.out.println(transferDTOs);
        List<Transfer> insertedTransfers = service.insertManyTransfers(transferDTOs);
        System.out.println(insertedTransfers);
        List<TransferDTO> insertedTransferDTOs = Mapper.transferListDTOFrom(insertedTransfers);
        return new ResponseEntity<>(insertedTransferDTOs, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<TransferDTO> updateTransfer(@RequestBody TransferDTO transferDTO) {
        // Implement validation ?
        System.out.println(transferDTO);
        Transfer updatedTransfer = service.updateOneTransfer(transferDTO);
        System.out.println(updatedTransfer);
        TransferDTO updatedTransferDTO = Mapper.newTransferDTOFrom(updatedTransfer);
        return new ResponseEntity<>(updatedTransferDTO, HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable("id")Long id) {
        if (id == null)
            throw new IllegalArgumentException("Error. Id cannot be null.");
        if (!service.existsById(id))
            throw new EntityNotFoundException("Error. Transfer with id: " + id + " does not exist.");

        service.deleteOneTransfer(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<TransferListView> getTransfersByDatesBetween(@RequestParam LocalDate from,
                                                                       @RequestParam(required = false) LocalDate to,
                                                                       @RequestParam(required = false) String client,
                                                                       @RequestParam(required = false) String operator) {
        List<Transfer> transferList = service.getTransfersByDatesBetween(from, to == null ? from : to, client, operator);
        List<TransferDTO> transferDTOList = Mapper.transferListDTOFrom(transferList);
        TransferListView transferListView = TransferListView.createFrom(transferDTOList);
        return new ResponseEntity<>(transferListView, HttpStatus.OK);
    }
}
