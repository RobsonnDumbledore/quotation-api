package com.br.quotation.usecase.merchant.impl;

import com.br.quotation.entities.Merchant;
import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.repositories.MerchantRepository;
import com.br.quotation.usecase.merchant.FindMerchantByCnpj;
import java.util.Optional;

/**
 *
 * @author Robson
 */
@Named
public class FindMerchantByCnpjImpl implements FindMerchantByCnpj {

    private MerchantRepository repository;

    @Inject
    public FindMerchantByCnpjImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Merchant> execute(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

}
