package com.br.quotation.repositories;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Product;
import static java.util.Collections.emptyList;
import com.br.quotation.utilities.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.br.quotation.extractor.ProductExtractor;

/**
 *
 * @author Robson
 */
@Repository
public class JdbcProductRepository implements ProductRepository {

    private JdbcTemplate jdbcTemplate;
    private ProductExtractor productExtractor;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate,
            ProductExtractor productExtractor) {

        this.jdbcTemplate = jdbcTemplate;
        this.productExtractor = productExtractor;
    }

    private static final String BASE_QUERY = "SELECT id, name FROM product";

    @Override
    public Optional<Product> find(Long id) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE id = ?");

        return this.jdbcTemplate.query(statement.toString(), new Long[]{id},
                productExtractor).stream().findFirst();
    }

    @Override
    public Page<Product> find(PageRequest page) {

        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" LIMIT ?")
                .append(" OFFSET ?");

        ArrayList<Integer> arguments = new ArrayList<>();
        arguments.add(page.getSize());
        arguments.add(page.offset());

        Set<Product> product = this.jdbcTemplate.query(statement.toString(),
                arguments.toArray(), productExtractor);

        return new Page(
                collectList(product),
                page.getPage(),
                page.getSize(),
                executeCountQuery()
        );
    }

    private List<Product> collectList(Set<Product> product) {
        if (product.isEmpty()) {
            return emptyList();
        } else {
            return product.stream().collect(Collectors.toList());
        }
    }

    private Integer executeCountQuery() {
        String countStatement = "SELECT count(*) AS total FROM product";
        return this.jdbcTemplate.queryForObject(countStatement, Integer.class);
    }

}
