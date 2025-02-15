package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.repository.TransferRepository;
import io.droksty.transfersdemo.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {

    // Section
    private final TransferRepository transferRepository;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }


    // Method implementations
    @Override
    public Transfer insertOneTransfer(TransferDTO transferDTO) {
        Transfer transfer = Mapper.newTransferFrom(transferDTO);
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> insertManyTransfers(List<TransferDTO> transferDTOs) {
        List<Transfer> transfers = Mapper.newTransferListFrom(transferDTOs);
        return transferRepository.saveAll(transfers);
    }

    @Override
    public Transfer updateTransfer(TransferDTO transferDTO) {
        if (!existsById(transferDTO.getId()))
            throw new EntityNotFoundException("Transfer with id " + transferDTO.getId() + " not found");
        Transfer transfer = Mapper.newTransferFrom(transferDTO);
        return transferRepository.save(transfer);
    }

    @Override
    public void deleteTransfer(Long id) {
        if (!existsById(id))
            throw new EntityNotFoundException("Transfer with id " + id + " not found");
        transferRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return transferRepository.existsById(id);
    }

    @Override
    public List<Transfer> getTransfers(LocalDate from, LocalDate to, String client, String operator) {
        List<Transfer> transfers = transferRepository.findAllByDateBetweenOrderByDateAscTimeAsc(from, to);

        return !client.isEmpty() || !operator.isEmpty() ? filterTransfers(transfers, client, operator) :transfers;
    }


    // Helper
    private List<Transfer> filterTransfers(List<Transfer> transfers, String client, String operator) {
        List<Transfer> filteredTransfers = new ArrayList<>();
        for (Transfer transfer : transfers) {
            if ((transfer.getClient() != null && transfer.getClient().getTitle().equals(client)) || transfer.getOperator() != null && transfer.getOperator().getTitle().equals(operator)) {
                filteredTransfers.add(transfer);
            }
        }
        return filteredTransfers;
    }
}
