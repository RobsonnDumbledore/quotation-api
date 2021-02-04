package com.br.quotation.usecase.quotation;

import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;

/**
 *
 * @author Robson
 */
public interface FindAllQuotation {

    PageResponse<Quotation> execute(Long providerID, Long merchantID, PageRequest pageRequest);

}
