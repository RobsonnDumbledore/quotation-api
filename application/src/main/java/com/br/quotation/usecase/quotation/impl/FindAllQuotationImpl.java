package com.br.quotation.usecase.quotation.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import com.br.quotation.repositories.QuotationRepository;
import com.br.quotation.usecase.quotation.FindAllQuotation;

/**
 *
 * @author Robson
 */
@Named
public class FindAllQuotationImpl implements FindAllQuotation {

    private QuotationRepository repository;

    @Inject
    public FindAllQuotationImpl(QuotationRepository repository) {
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
