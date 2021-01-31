package com.br.quotation.repositories;

import com.br.quotation.entities.Merchant;
import com.br.quotation.utilities.Page;
import com.br.quotation.utilities.PageRequest;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface MerchantRepository {

    Merchant create(Merchant merchant);

    Merchant update(Merchant merchant);

    Optional<Merchant> find(Long id);

    Page<Merchant> find(PageRequest page);

}
