package com.br.quotation.usecase.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Merchant;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import com.br.quotation.usecase.FindAllMerchant;
import com.br.quotation.repositories.MerchantRepository;

/**
 *
 * @author Robson
 */
@Named
public class FindAllMerchantImpl implements FindAllMerchant {

    private MerchantRepository repository;

    @Inject
    public FindAllMerchantImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public PageResponse<Merchant> execute(PageRequest pageRequest) {
        return convert(repository.find(pageRequest));
    }

    private PageResponse<Merchant> convert(Page<Merchant> merchants) {
        return new PageResponse<>(
                merchants.getContent(),
                merchants.getPageNumber(),
                merchants.size(),
                merchants.isLast(),
                merchants.totalPages()
        );
    }

}
