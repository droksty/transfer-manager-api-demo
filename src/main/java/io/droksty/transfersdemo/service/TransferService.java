package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Associate;
import io.droksty.transfersdemo.model.Transfer;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface TransferService {

    /**
     * Creates and persists a new {@link Transfer} from the data carried by the {@link TransferDTO}.
     * @param transferDTO   The DTO containing the transfer data.
     * @return  The inserted {@code Transfer}.
     * @throws IllegalArgumentException if the {@code TransferDTO} contains a non-null {@code id}.
     */
    Transfer insertOneTransfer(TransferDTO transferDTO);

    /**
     * Creates and persists many new {@link Transfer Transfer(s)} from the data carried by the {@link TransferDTO TransferDTO(s)}.
     * @param transferDTOList   The list of DTOs containing the transfer data.
     * @return  The inserted {@code Transfer(s)}.
     * @throws IllegalArgumentException if any of the provided {@code TransferDTO(s)} contain a non-null {@code id}.
     */
    List<Transfer> insertManyTransfers(List<TransferDTO> transferDTOList);

    /**
     * Updates the {@link Transfer} instance with the data carried by the {@link TransferDTO}.
     * @param transferDTO   The DTO containing the transfer data.
     * @return  The updated {@code Transfer}.
     * @throws EntityNotFoundException  if the {@code TransferDTO} does not map to an existing {@code Transfer}.
     */
    Transfer updateTransfer(TransferDTO transferDTO);

    /**
     * Removes a {@link Transfer}.
     * @param id    The id of the {@code Transfer} to be removed.
     * @throws EntityNotFoundException  if the {@code id} does not match an existing {@code Transfer}.
     */
    void deleteTransfer(Long id);

    /**
     * Returns true if a {@link Transfer} with a matching {@code id} exists in the database.
     * @param id    The {@code id} to match an existing {@code Transfer} to.
     * @return      True if a {@code Transfer} with a matching {@code id} exists in the database, false otherwise.
     */
    boolean existsById(Long id);

    /**
     * Returns all the {@link Transfer Transfers(s)} matching the parameter criteria.
     * @param from         The date to search from.
     * @param to           The date to search until. (optional)
     * @param clientUid    The {@link Associate} who ordered the transfers.    (optional)
     * @param operatorUid  The {@link Associate} who operated the transfers.   (optional)
     * @return             The {@code Transfers} matching the parameter criteria.
     */
    List<Transfer> getTransfers(LocalDate from, LocalDate to, String clientUid, String operatorUid);
}
