package com.br.quotation.usecase.merchant.impl;

import javax.inject.Named;
import java.util.Optional;
import javax.inject.Inject;
import com.br.quotation.entities.Merchant;
import com.br.quotation.usecase.merchant.FindMerchant;
import com.br.quotation.repositories.MerchantRepository;

/**
 *
 * @author Robson
 */
@Named
public class FindMerchantImpl implements FindMerchant {

    private MerchantRepository repository;

    @Inject
    public FindMerchantImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Merchant> execute(Merchant merchant) {
        return repository.find(merchant.getId());
    }

}
