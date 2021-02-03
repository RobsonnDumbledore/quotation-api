package com.br.quotation.usecase.provider.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Provider;
import com.br.quotation.repositories.ProviderRepository;
import com.br.quotation.usecase.provider.UpdateProvider;

/**
 *
 * @author Robson
 */
@Named
public class UpdateProviderImpl implements UpdateProvider {

    private ProviderRepository repository;

    @Inject
    public UpdateProviderImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Provider execute(Provider provider) {
        return repository.update(provider);
    }

}
