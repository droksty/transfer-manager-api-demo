package io.droksty.transfersdemo.rest;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.dto.TransferListView;
import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.service.TransferService;
import io.droksty.transfersdemo.util.Mapper;
import jakarta.validation.Valid;
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
    private final TransferService service;

    @Autowired
    public TransferRestController(TransferService service) {
        this.service = service;
    }

    /* -- Endpoints -- */

    @PostMapping("")
    public ResponseEntity<TransferDTO> newTransfer(@RequestBody @Valid TransferDTO transferDTO) {
        System.out.println(transferDTO);
        Transfer insertedTransfer = service.insertOneTransfer(transferDTO);
        System.out.println(insertedTransfer);
        TransferDTO insertedTransferDTO = Mapper.newTransferDTOFrom(insertedTransfer);
        return new ResponseEntity<>(insertedTransferDTO, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<TransferDTO>> newTransfers(@RequestBody @Valid List<TransferDTO> transferDTOs) {
        System.out.println(transferDTOs);
        List<Transfer> insertedTransfers = service.insertManyTransfers(transferDTOs);
        System.out.println(insertedTransfers);
        List<TransferDTO> insertedTransferDTOs = Mapper.transferListDTOFrom(insertedTransfers);
        return new ResponseEntity<>(insertedTransferDTOs, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<TransferDTO> updateTransfer(@RequestBody @Valid TransferDTO transferDTO) {
        System.out.println(transferDTO);
        Transfer updatedTransfer = service.updateTransfer(transferDTO);
        System.out.println(updatedTransfer);
        TransferDTO updatedTransferDTO = Mapper.newTransferDTOFrom(updatedTransfer);
        return new ResponseEntity<>(updatedTransferDTO, HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransfer(@PathVariable("id")Long id) {
        service.deleteTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<TransferListView> getTransfersByDatesBetween(@RequestParam LocalDate from,
                                                                       @RequestParam(required = false) LocalDate to,
                                                                       @RequestParam(required = false) String client,
                                                                       @RequestParam(required = false) String operator) {
        List<Transfer> transferList = service.getTransfers(from, to == null ? from : to, client, operator);
        List<TransferDTO> transferDTOList = Mapper.transferListDTOFrom(transferList);
        TransferListView transferListView = TransferListView.createFrom(transferDTOList);
        return new ResponseEntity<>(transferListView, HttpStatus.OK);
    }
}
