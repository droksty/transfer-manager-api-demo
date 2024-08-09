package io.droksty.transfersdemo.util;

import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Transfer;

public final class Mapper {

    // No instances of this class should be available
    private Mapper() {}


    // Utility methods
    public static Transfer newTransferFrom(TransferDTO transferDTO) {
        return new Transfer(
                transferDTO.getId(),
                transferDTO.getPickupDate(),
                transferDTO.getPickupTime(),
                transferDTO.getPassengerName(),
                transferDTO.getTotalPax(),
                transferDTO.getType(),
                transferDTO.getTransferFrom(),
                transferDTO.getTransferTo(),
                transferDTO.getPriceTotal(),
                transferDTO.getPriceNet(),
                transferDTO.getClient(),
                transferDTO.getOperator(),
                transferDTO.getOperatorCost()
        );
    }

    public static TransferDTO newTransferDTOFrom(Transfer transfer) {
        return new TransferDTO(
                transfer.getId(),
                transfer.getPickupDate(),
                transfer.getPickupTime(),
                transfer.getPassengerName(),
                transfer.getTotalPax(),
                transfer.getType(),
                transfer.getTransferFrom(),
                transfer.getTransferTo(),
                transfer.getPriceTotal(),
                transfer.getPriceNet(),
                transfer.getClient(),
                transfer.getOperator(),
                transfer.getOperatorCost()
        );
    }
}
