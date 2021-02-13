package com.br.quotation.usecase.quotation.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Quotation;
import com.br.quotation.repositories.QuotationRepository;
import com.br.quotation.usecase.quotation.UpdateQuotation;

/**
 *
 * @author Robson
 */
@Named
public class UpdateQuotationImpl implements UpdateQuotation {

    private QuotationRepository repository;

    @Inject
    public UpdateQuotationImpl(QuotationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Quotation quotation) {
        repository.update(quotation);
    }

}
