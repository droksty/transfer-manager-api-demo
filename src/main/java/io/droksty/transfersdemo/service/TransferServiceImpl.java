package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    // Section
    private final TransferRepository transferRepository;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }


    // Section
    @Override
    public Transfer insertOneTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> insertManyTransfers(List<Transfer> transfers) {
        return transferRepository.saveAll(transfers);
    }

    @Override
    public Transfer updateOneTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public void deleteOneTransfer(Integer id) {
        transferRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return transferRepository.existsById(id);
    }

    @Override
    public List<Transfer> getTransfersByDate(LocalDate date) {
        return transferRepository.findAllByPickupDateEqualsOrderByPickupTimeAsc(date);
    }

    @Override
    public List<Transfer> getTransfersByDatesBetween(LocalDate from, LocalDate to) {
        return transferRepository.findAllByPickupDateBetweenOrderByPickupDateAscPickupTimeAsc(from, to);
    }

}
