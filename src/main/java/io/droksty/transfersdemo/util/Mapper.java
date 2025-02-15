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
    public static Transfer newTransferFrom(TransferDTO dto) {
        Transfer transfer = new Transfer(dto.getId(), dto.getPickupDate(), dto.getPickupTime(), dto.getTransferFrom(), dto.getTransferTo());
        transfer.setName(dto.getPassengerName());
        transfer.setPax(dto.getTotalPax());
        transfer.setType(dto.getType());
        transfer.setTotal(dto.getPriceTotal());
        transfer.setNet(dto.getPriceNet());
        transfer.setClient(dto.getClient() == null ? null : newAssociateFrom(dto.getClient()));
        transfer.setOperator(dto.getOperator() == null ? null : newAssociateFrom(dto.getOperator()));
        transfer.setCost(dto.getOperatorCost());
        transfer.setComments(dto.getComments());
        transfer.setPaidBy(dto.getPaidBy());
        return transfer;
    }

    public static TransferDTO newTransferDTOFrom(Transfer transfer) {
        //should clients be transactional?
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setPickupDate(transfer.getDate());
        dto.setPickupTime(transfer.getTime());
        dto.setPassengerName(transfer.getName());
        dto.setTotalPax(transfer.getPax());
        dto.setType(transfer.getType());
        dto.setTransferFrom(transfer.getFrom());
        dto.setTransferTo(transfer.getTo());
        dto.setPriceTotal(transfer.getTotal());
        dto.setPriceNet(transfer.getNet());
        dto.setClient(transfer.getClient() == null ? null : newAssociateDTOFrom(transfer.getClient()));
        dto.setOperator(transfer.getOperator() == null ? null : newAssociateDTOFrom(transfer.getOperator()));
        dto.setOperatorCost(transfer.getCost());
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
