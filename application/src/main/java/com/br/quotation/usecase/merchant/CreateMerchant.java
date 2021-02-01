package com.br.quotation.usecase.merchant;

import com.br.quotation.entities.Merchant;

/**
 *
 * @author Robson
 */
public interface CreateMerchant {
    
    Merchant execute(Merchant merchant);
}
