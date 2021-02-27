package com.br.quotation.usecase.merchant.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Merchant;
import com.br.quotation.repositories.MerchantRepository;
import com.br.quotation.usecase.merchant.CreateMerchant;

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
    public void execute(Merchant merchant) {
        repository.create(merchant);
    }

}
