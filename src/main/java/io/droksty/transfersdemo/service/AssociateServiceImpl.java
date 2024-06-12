package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Associate;
import io.droksty.transfersdemo.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateServiceImpl implements AssociateService {

    // Section
    private final AssociateRepository associateRepository;

    @Autowired
    public AssociateServiceImpl(AssociateRepository associateRepository) {
        this.associateRepository = associateRepository;
    }


    // Section
    @Override
    public Associate insertOneAssociate(Associate associate) {
        return associateRepository.save(associate);
    }

    @Override
    public List<Associate> insertManyAssociates(List<Associate> associates) {
        return associateRepository.saveAll(associates);
    }

    @Override
    public List<Associate> getAllAssociates() {
        return associateRepository.findAll();
    }

}
