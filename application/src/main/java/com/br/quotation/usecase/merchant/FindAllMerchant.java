package com.br.quotation.usecase.merchant;

import com.br.quotation.entities.Merchant;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;

/**
 *
 * @author Robson
 */
public interface FindAllMerchant {

    PageResponse<Merchant> execute(PageRequest pageRequest);

}
