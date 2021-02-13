package com.br.quotation.usecase.product.impl;

import javax.inject.Named;
import javax.inject.Inject;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Product;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import com.br.quotation.repositories.ProductRepository;
import com.br.quotation.usecase.product.FindAllProduct;

/**
 *
 * @author Robson
 */
@Named
public class FindAllProductImpl implements FindAllProduct {

    private ProductRepository repository;

    @Inject
    public FindAllProductImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public PageResponse<Product> execute(PageRequest pageRequest) {
        return convert(repository.find(pageRequest));
    }

    private PageResponse<Product> convert(Page<Product> products) {
        return new PageResponse<>(
                products.getContent(),
                products.getPageNumber(),
                products.size(),
                products.isLast(),
                products.totalPages()
        );
    }

}
