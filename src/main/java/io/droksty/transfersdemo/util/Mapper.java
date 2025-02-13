package io.droksty.transfersdemo.util;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.dto.TransferDTO;
import io.droksty.transfersdemo.model.Associate;
import io.droksty.transfersdemo.model.Transfer;

import java.util.ArrayList;
import java.util.List;

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
                transferDTO.getClient() == null ? null : newAssociateFrom(transferDTO.getClient()),
                transferDTO.getOperator() == null ? null : newAssociateFrom(transferDTO.getOperator()),
                transferDTO.getOperatorCost(),
                transferDTO.getComments(),
                transferDTO.getPaidBy()
        );
    }

    public static TransferDTO newTransferDTOFrom(Transfer transfer) {
        //should clients be transactional?
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setPickupDate(transfer.getPickupDate());
        dto.setPickupTime(transfer.getPickupTime());
        dto.setPassengerName(transfer.getPassengerName());
        dto.setTotalPax(transfer.getTotalPax());
        dto.setType(transfer.getType());
        dto.setTransferFrom(transfer.getTransferFrom());
        dto.setTransferTo(transfer.getTransferTo());
        dto.setPriceTotal(transfer.getPriceTotal());
        dto.setPriceNet(transfer.getPriceNet());
        dto.setClient(transfer.getClient() == null ? null : newAssociateDTOFrom(transfer.getClient()));
        dto.setOperator(transfer.getOperator() == null ? null : newAssociateDTOFrom(transfer.getOperator()));
        dto.setOperatorCost(transfer.getOperatorCost());
        dto.setComments(transfer.getComments());
        dto.setPaidBy(transfer.getPaidBy());
        return dto;
    }

    public static Associate newAssociateFrom(AssociateDTO associateDTO) {
        return new Associate(
                associateDTO.getId(),
                associateDTO.getTitle()
        );
    }

    public static AssociateDTO newAssociateDTOFrom(Associate associate) {
        return new AssociateDTO(
                associate.getId(),
                associate.getTitle()
        );
    }

    public static List<Transfer> newTransferListFrom(List<TransferDTO> transferDTOList) {
        List<Transfer> transferList = new ArrayList<>(transferDTOList.size());
        transferDTOList.forEach(transferDTO -> transferList.add(newTransferFrom(transferDTO)));
        return transferList;
    }

    public static List<TransferDTO> transferListDTOFrom(List<Transfer> transferList) {
        List<TransferDTO> transferDTOList = new ArrayList<>(transferList.size());
        transferList.forEach(transfer -> transferDTOList.add(newTransferDTOFrom(transfer)));
        return transferDTOList;
    }

    public static List<AssociateDTO> newAssociateDTOListFrom(List<Associate> associates) {
        List<AssociateDTO> associatesDTO = new ArrayList<>();
        associates.forEach(associate -> associatesDTO.add(newAssociateDTOFrom(associate)));
        return associatesDTO;
    }
}
