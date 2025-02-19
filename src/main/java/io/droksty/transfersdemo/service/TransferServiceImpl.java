package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;
import io.droksty.transfersdemo.repository.TransferRepository;
import io.droksty.transfersdemo.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    /* -- Method implementations -- */

    @Override
    public Transfer insertOneTransfer(TransferDTO transferDTO) {
        if (transferDTO.getId() != null)
            throw new IllegalArgumentException("Illegal data: Non-null ID");
        Transfer transfer = Mapper.newTransferFrom(transferDTO);
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> insertManyTransfers(List<TransferDTO> transferDTOs) {
        transferDTOs.forEach(transferDTO -> {
            if (transferDTO.getId() != null)
                throw new IllegalArgumentException("Illegal data: Non-null ID");
        });
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
    public List<Transfer> getTransfers(LocalDate from, LocalDate to, String clientUid, String operatorUid) {
        List<Transfer> transfers;

        if (clientUid.isEmpty() && operatorUid.isEmpty())
            transfers = transferRepository.findAllByDateBetweenOrderByDateAscTimeAsc(from, to);
        else if (operatorUid.isEmpty())
            transfers = transferRepository.findAllByDateBetweenAndClientUidEqualsOrderByDateAscTimeAsc(from, to, clientUid);
        else if (clientUid.isEmpty())
            transfers = transferRepository.findAllByDateBetweenAndOperatorUidEqualsOrderByDateAscTimeAsc(from, to, operatorUid);
        else
            transfers = transferRepository.findAllByDateBetweenAndClientUidEqualsOrOperatorUidEqualsOrderByDateAscTimeAsc(from, to, operatorUid, clientUid);

        return transfers;
    }
}
