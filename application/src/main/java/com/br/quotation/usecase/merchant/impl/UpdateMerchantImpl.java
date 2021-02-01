package com.br.quotation.usecase.merchant.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Merchant;
import com.br.quotation.usecase.merchant.UpdateMerchant;
import com.br.quotation.repositories.MerchantRepository;

/**
 *
 * @author Robson
 */
@Named
public class UpdateMerchantImpl implements UpdateMerchant {

    private MerchantRepository repository;

    @Inject
    public UpdateMerchantImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Merchant execute(Merchant merchant) {
        return repository.update(merchant);
    }

}
