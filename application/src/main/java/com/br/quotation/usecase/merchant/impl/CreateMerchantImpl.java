package com.br.quotation.usecase.merchant.impl;

import com.br.quotation.entities.Merchant;
import com.br.quotation.repositories.MerchantRepository;
import javax.inject.Named;
import com.br.quotation.usecase.merchant.CreateMerchant;
import javax.inject.Inject;

/**
 *
 * @author Robson
 */
@Named
public class CreateMerchantImpl implements CreateMerchant {
    
    private MerchantRepository repository;

    @Inject
    public CreateMerchantImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Merchant execute(Merchant merchant) {
        return repository.create(merchant);
    }

}
