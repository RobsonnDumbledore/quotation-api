package com.br.quotation.usecase.merchant.impl;

import javax.inject.Named;
import java.util.Optional;
import javax.inject.Inject;
import com.br.quotation.entities.Merchant;
import com.br.quotation.repositories.MerchantRepository;
import com.br.quotation.usecase.merchant.FindMerchantByEmail;

/**
 *
 * @author Robson
 */
@Named
public class FindMerchantByEmailImpl implements FindMerchantByEmail {

    private MerchantRepository repository;

    @Inject
    public FindMerchantByEmailImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Merchant> execute(String email) {
        return repository.findByEmail(email);
    }

}
