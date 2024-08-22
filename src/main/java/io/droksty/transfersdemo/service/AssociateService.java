package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;

import java.util.List;

public interface AssociateService {
    Associate       insertAssociate(AssociateDTO associateDTO);
    Associate       updateAssociate(AssociateDTO associateDTO);
    void            deleteAssociate(Long id);

    boolean         existsById(Long id);
    List<Associate> getAllAssociates();
}
