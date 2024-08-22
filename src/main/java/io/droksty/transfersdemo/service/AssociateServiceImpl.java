package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.dto.AssociateDTO;
import io.droksty.transfersdemo.model.Associate;
import io.droksty.transfersdemo.repository.AssociateRepository;
import io.droksty.transfersdemo.util.Mapper;
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


    // Method Implementations
    @Override
    public Associate insertAssociate(AssociateDTO associateDTO) {
        Associate associate = Mapper.newAssociateFrom(associateDTO);
        return associateRepository.save(associate);
    }

    @Override
    public Associate updateAssociate(AssociateDTO associateDTO) {
        Associate associate = Mapper.newAssociateFrom(associateDTO);
        return associateRepository.save(associate);
    }

    @Override
    public void deleteAssociate(Long id) {
        associateRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return associateRepository.existsById(id);
    }

    @Override
    public List<Associate> getAllAssociates() {
        return associateRepository.findAll();
    }

}
