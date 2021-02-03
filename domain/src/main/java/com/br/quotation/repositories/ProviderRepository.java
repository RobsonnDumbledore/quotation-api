package com.br.quotation.repositories;

import java.util.Optional;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Provider;
import com.br.quotation.utilities.PageRequest;

/**
 *
 * @author Robson
 */
public interface ProviderRepository {

    Optional<Provider> find(Long id);
    
    Provider create(Provider provider);

    Provider update(Provider provider);

    Page<Provider> find(PageRequest page);
    
    Optional<Provider> findByCnpj(String cnpj);
    
    Optional<Provider> findByEmail(String email);
}
