package com.br.quotation.usecase.product.impl;

import javax.inject.Named;
import java.util.Optional;
import javax.inject.Inject;
import com.br.quotation.entities.Product;
import com.br.quotation.repositories.ProductRepository;
import com.br.quotation.usecase.product.FindProduct;

/**
 *
 * @author Robson
 */
@Named
public class FindProductImpl implements FindProduct {
    
    private ProductRepository repository;

    @Inject
    public FindProductImpl(ProductRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Optional<Product> execute(Long id) {
        return repository.find(id);
    }
    
}
