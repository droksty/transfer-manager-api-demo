package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Associate;

import java.util.List;

public interface AssociateService {
    Associate insertOneAssociate(Associate client);
    List<Associate> insertManyAssociates(List<Associate> clients);
    List<Associate> getAllAssociates();
}
