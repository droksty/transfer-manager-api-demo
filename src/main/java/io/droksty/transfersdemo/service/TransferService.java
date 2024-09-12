package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;

import java.time.LocalDate;
import java.util.List;


public interface TransferService {
    Transfer        insertOneTransfer(TransferDTO transferDTO);
    List<Transfer>  insertManyTransfers(List<TransferDTO> transferDTOList);
    Transfer        updateTransfer(TransferDTO transfer);
    void            deleteTransfer(Long id);

    boolean         existsById(Long Id);
    List<Transfer>  getTransfers(LocalDate from, LocalDate to, String client, String operator);
}
