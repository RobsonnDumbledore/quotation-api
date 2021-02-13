package com.br.quotation.repositories;

import java.util.Optional;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Product;
import com.br.quotation.utilities.PageRequest;

/**
 *
 * @author Robson
 */
public interface ProductRepository {

    Optional<Product> find(Long id);

    Page<Product> find(PageRequest page);

}
