package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Transfer;

import java.time.LocalDate;
import java.util.List;


public interface TransferService {
    Transfer insertOneTransfer(Transfer transfer);
    List<Transfer> insertManyTransfers(List<Transfer> transfers);
    Transfer updateOneTransfer(Transfer transfer);
    void deleteOneTransfer(Integer id);

    boolean existsById(Integer Id);
    List<Transfer> getTransfersByDate(LocalDate date);
}
