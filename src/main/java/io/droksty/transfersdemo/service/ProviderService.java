package io.droksty.transfersdemo.service;


import io.droksty.transfersdemo.model.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> insertManyProviders(List<Provider> providers);
}
