package com.br.quotation.usecase.provider.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Provider;
import com.br.quotation.repositories.ProviderRepository;
import com.br.quotation.usecase.provider.CreateProvider;

/**
 *
 * @author Robson
 */
@Named
public class CreateProviderImpl implements CreateProvider {

    private ProviderRepository repository;

    @Inject
    public CreateProviderImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Provider provider) {
        repository.create(provider);
    }

}
