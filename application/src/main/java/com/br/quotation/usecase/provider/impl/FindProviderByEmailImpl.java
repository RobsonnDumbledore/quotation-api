package com.br.quotation.usecase.provider.impl;

import com.br.quotation.entities.Provider;
import com.br.quotation.repositories.ProviderRepository;
import com.br.quotation.usecase.provider.FindProviderByEmail;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Robson
 */
@Named
public class FindProviderByEmailImpl implements FindProviderByEmail {

    private ProviderRepository repository;

    @Inject
    public FindProviderByEmailImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Provider> execute(String email) {
        return repository.findByEmail(email);
    }

}
