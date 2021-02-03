package com.br.quotation.usecase.provider.impl;

import com.br.quotation.entities.Provider;
import com.br.quotation.repositories.ProviderRepository;
import com.br.quotation.usecase.provider.CreateProvider;

/**
 *
 * @author Robson
 */
public class CreateProviderImpl implements CreateProvider {

    private ProviderRepository repository;

    @Override
    public Provider execute(Provider provider) {
        return repository.create(provider);
    }

}
