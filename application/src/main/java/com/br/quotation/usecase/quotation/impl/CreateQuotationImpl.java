package com.br.quotation.usecase.quotation.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.entities.Quotation;
import com.br.quotation.repositories.QuotationRepository;
import com.br.quotation.usecase.quotation.CreateQuotation;

/**
 *
 * @author Robson
 */
@Named
public class CreateQuotationImpl implements CreateQuotation {

    private QuotationRepository repository;

    @Inject
    public CreateQuotationImpl(QuotationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Quotation quotation) {
        repository.create(quotation);
    }

}
