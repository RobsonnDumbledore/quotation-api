package com.br.quotation.repositories;

import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;

/**
 *
 * @author Robson
 */
public interface QuotationRepository {

    void create(Quotation quotation);

    void update(Quotation quotation);

    Page<Quotation> find(Long providerID, Long merchantID, PageRequest page);

}
