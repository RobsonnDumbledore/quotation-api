package com.br.quotation.usecase.product;

import com.br.quotation.entities.Product;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;

/**
 *
 * @author Robson
 */
public interface FindAllProduct {

    PageResponse<Product> execute(PageRequest pageRequest);

}
