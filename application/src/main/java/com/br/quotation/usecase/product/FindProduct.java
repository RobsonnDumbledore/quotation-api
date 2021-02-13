package com.br.quotation.usecase.product;

import com.br.quotation.entities.Product;
import java.util.Optional;

/**
 *
 * @author Robson
 */
public interface FindProduct {

    Optional<Product> execute(Long id);

}
