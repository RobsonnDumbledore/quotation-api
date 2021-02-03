package com.br.quotation.usecase.merchant;

import com.br.quotation.entities.Merchant;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface FindMerchantByCnpj {
    
    Optional<Merchant> execute(String cnpj);
    
}
