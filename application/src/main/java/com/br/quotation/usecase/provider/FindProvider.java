package com.br.quotation.usecase.provider;

import java.util.Optional;
import com.br.quotation.entities.Provider;

/**
 *
 * @author Robson
 */
public interface FindProvider {

    Optional<Provider> execute(Long id);

}
