package com.br.quotation.usecase;

import com.br.quotation.entities.Merchant;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface FindMerchant {

    Optional<Merchant> execute(Merchant merchant);

}
