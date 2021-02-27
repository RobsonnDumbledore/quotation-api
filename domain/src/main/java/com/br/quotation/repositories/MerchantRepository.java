package com.br.quotation.repositories;

import java.util.Optional;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Merchant;
import com.br.quotation.utilities.PageRequest;

/**
 *
 * @author Robson
 */
public interface MerchantRepository {

    Optional<Merchant> find(Long id);

    void create(Merchant merchant);

    void update(Merchant merchant);

    Page<Merchant> find(PageRequest page);

    Optional<Merchant> findByCnpj(String cnpj);

    Optional<Merchant> findByEmail(String email);

}
