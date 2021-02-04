package com.br.quotation.usecase.quotation;

import com.br.quotation.entities.Quotation;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface UpdateQuotation {
    
    Optional<Quotation> execute(Quotation quotation);
    
}
