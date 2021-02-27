package com.br.quotation.extractor;

import java.util.Set;
import java.util.HashSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.quotation.entities.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Robson
 */
@Component
public class ProductExtractor implements ResultSetExtractor<Set<Product>> {

    @Override
    public Set<Product> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Set<Product> products = new HashSet<>();

        while (resultSet.next()) {
            products.add(map(resultSet));
        }

        return products;
    }

    private Product map(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }

}
