package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface AssociateService {
    /**
     * Creates and persists a new {@link Associate} from the data carried by the {@link AssociateDTO}.
     * @param associateDTO  The DTO containing the {@code Associate} data.
     * @return  The inserted {@code Associate}.
     * @throws IllegalArgumentException If the {@code AssociateDTO} contains a non-null {@code id}.
     */
    Associate insertAssociate(AssociateDTO associateDTO);

    /**
     * Updates the {@link Associate} instance with the data carried by the {@link AssociateDTO}.
     * @param associateDTO  The DTO containing the {@code Associate} data.
     * @return  The updated {@code Associate}.
     * @throws EntityNotFoundException  if the {@code AssociateDTO} does not map to an existing {@code Associate}.
     */
    Associate updateAssociate(AssociateDTO associateDTO);

    /**
     * Removes a {@link Associate}.
     * @param id    The id of the {@code Associate} to be removed.
     * @throws EntityNotFoundException  if the {@code id} does not match an existing {@code Associate}.
     */
    void deleteAssociate(Long id);

    /**
     * Returns true if an {@link Associate} matching the {@code id} exists in the database.
     * @param id    The id to match an existing {@code Associate} to.
     * @return      {@code true} if a {@code Associate} with a matching {@code id} exists in the database,
     *              {@code false} otherwise.
     */
    boolean         existsById(Long id);

    /**
     * Returns all {@link Associate Associate(s)}.
     * @return  all {@code Associate(s)}.
     */
    List<Associate> getAllAssociates();
}
