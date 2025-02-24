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
        Transfer transfer = new Transfer(dto.getId(), dto.getDate(), dto.getTime(), dto.getFrom(), dto.getTo());
        transfer.setName(dto.getName());
        transfer.setPax(dto.getPax());
        transfer.setType(dto.getType());
        transfer.setTotal(dto.getTotal());
        transfer.setNet(dto.getNet());
        transfer.setClient(dto.getClient() == null ? null : newAssociateFrom(dto.getClient()));
        transfer.setOperator(dto.getOperator() == null ? null : newAssociateFrom(dto.getOperator()));
        transfer.setCost(dto.getCost());
        transfer.setComments(dto.getComments());
        transfer.setPaidBy(dto.getPaidBy());
        return transfer;
    }

    public static TransferDTO newTransferDTOFrom(Transfer transfer) {
        //should clients be transactional?
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setDate(transfer.getDate());
        dto.setTime(transfer.getTime());
        dto.setName(transfer.getName());
        dto.setPax(transfer.getPax());
        dto.setType(transfer.getType());
        dto.setFrom(transfer.getFrom());
        dto.setTo(transfer.getTo());
        dto.setTotal(transfer.getTotal());
        dto.setNet(transfer.getNet());
        dto.setClient(transfer.getClient() == null ? null : newAssociateDTOFrom(transfer.getClient()));
        dto.setOperator(transfer.getOperator() == null ? null : newAssociateDTOFrom(transfer.getOperator()));
        dto.setCost(transfer.getCost());
        dto.setComments(transfer.getComments());
        dto.setPaidBy(transfer.getPaidBy());
        return dto;
    }

    public static Associate newAssociateFrom(AssociateDTO associateDTO) {
        return new Associate(associateDTO.getId(), associateDTO.getTitle(), associateDTO.getUid());
    }

    public static AssociateDTO newAssociateDTOFrom(Associate associate) {
        return new AssociateDTO(associate.getId(), associate.getTitle(), associate.getUid());
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
