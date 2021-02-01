package com.br.quotation.usecase;

import com.br.quotation.entities.Merchant;

/**
 *
 * @author Robson
 */
public interface CreateMerchant {
    
    Merchant execute(Merchant merchant);
}
