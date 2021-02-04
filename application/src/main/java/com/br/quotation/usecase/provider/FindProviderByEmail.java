package com.br.quotation.usecase.provider;

import com.br.quotation.entities.Provider;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface FindProviderByEmail {

    Optional<Provider> execute(String email);

}
