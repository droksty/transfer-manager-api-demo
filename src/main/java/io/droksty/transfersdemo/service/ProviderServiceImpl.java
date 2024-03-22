package io.droksty.transfersdemo.service;

import io.droksty.transfersdemo.model.Provider;
import io.droksty.transfersdemo.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    // Section
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }


    // Section
    @Override
    public List<Provider> insertManyProviders(List<Provider> providers) {
        return providerRepository.saveAll(providers);
    }
}
