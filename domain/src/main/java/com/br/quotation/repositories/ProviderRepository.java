package com.br.quotation.repositories;

import com.br.quotation.entities.Provider;
import com.br.quotation.utilities.Page;
import com.br.quotation.utilities.PageRequest;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface ProviderRepository {

    Provider create(Provider provider);

    Provider update(Provider provider);

    Optional<Provider> find(Long id);

    Page<Provider> find(PageRequest page);
}
