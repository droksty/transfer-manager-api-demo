package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;

import java.util.List;

public interface AssociateService {
    Associate insertAssociate(AssociateDTO associateDTO);
    /*List<Associate> insertManyAssociates(List<Associate> clients);*/
    List<Associate> getAllAssociates();
}
