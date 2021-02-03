package com.br.quotation.usecase.provider.impl;

import javax.inject.Named;
import java.util.Optional;
import javax.inject.Inject;
import com.br.quotation.entities.Provider;
import com.br.quotation.usecase.provider.FindProvider;
import com.br.quotation.repositories.ProviderRepository;

/**
 *
 * @author Robson
 */
@Named
public class FindProviderImpl implements FindProvider {

    private ProviderRepository repository;

    @Inject
    public FindProviderImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Provider> execute(Long id) {
        return repository.find(id);
    }

}
