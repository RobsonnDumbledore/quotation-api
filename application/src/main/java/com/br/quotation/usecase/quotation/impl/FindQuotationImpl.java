package com.br.quotation.usecase.quotation.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import com.br.quotation.usecase.quotation.FindQuotation;
import com.br.quotation.repositories.QuotationRepository;

/**
 *
 * @author Robson
 */
@Named
public class FindQuotationImpl implements FindQuotation {

    private QuotationRepository repository;

    @Inject
    public FindQuotationImpl(QuotationRepository repository) {
        this.repository = repository;
    }

    @Override
    public PageResponse<Quotation> execute(Long providerID, Long merchantID, PageRequest pageRequest) {
        return convert(repository.find(providerID, merchantID, pageRequest));
    }

    private PageResponse<Quotation> convert(Page<Quotation> quotation) {
        return new PageResponse<>(
                quotation.getContent(),
                quotation.getPageNumber(),
                quotation.size(),
                quotation.isLast(),
                quotation.totalPages()
        );
    }

}
