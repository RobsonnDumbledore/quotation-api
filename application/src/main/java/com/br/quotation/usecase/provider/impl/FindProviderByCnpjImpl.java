package com.br.quotation.usecase.provider.impl;

import java.util.Optional;
import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Provider;
import com.br.quotation.repositories.ProviderRepository;
import com.br.quotation.usecase.provider.FindProviderByCnpj;

/**
 *
 * @author Robson
 */
@Named
public class FindProviderByCnpjImpl implements FindProviderByCnpj {

    private ProviderRepository repository;

    @Inject
    public FindProviderByCnpjImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Provider> execute(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

}
