package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;

import java.time.LocalDate;
import java.util.List;


public interface TransferService {
    Transfer        insertOneTransfer(TransferDTO transferDTO);
    List<Transfer>  insertManyTransfers(List<TransferDTO> transferDTOList);
    Transfer        updateOneTransfer(TransferDTO transfer);
    void            deleteOneTransfer(Long id);

    boolean         existsById(Long Id);
    List<Transfer>  getTransfersByDatesBetween(LocalDate from, LocalDate to, String client, String operator);
}
