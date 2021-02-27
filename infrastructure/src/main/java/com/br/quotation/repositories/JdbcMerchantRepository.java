package com.br.quotation.repositories;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import javax.inject.Inject;
import java.util.stream.Collectors;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Merchant;
import com.br.quotation.utilities.PageRequest;
import static java.util.Collections.emptyList;
import org.springframework.jdbc.core.JdbcTemplate;
import com.br.quotation.extractor.MerchantExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public class JdbcMerchantRepository implements MerchantRepository {

    
    private JdbcTemplate jdbcTemplate;
    private MerchantExtractor merchantExtractor;

    @Inject
    public JdbcMerchantRepository(JdbcTemplate jdbcTemplate,
            MerchantExtractor merchantExtractor) {

        this.jdbcTemplate = jdbcTemplate;
        this.merchantExtractor = merchantExtractor;
    }

    private static final String BASE_QUERY = "SELECT id, name, cnpj, email, active FROM merchant";

    @Override
    public Optional<Merchant> find(Long id) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE id = ?");

        return this.jdbcTemplate.query(statement.toString(), new Long[]{id},
                merchantExtractor).stream().findFirst();
    }
    

    @Override
    public Merchant create(Merchant merchant) {
        String statement = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";

        this.jdbcTemplate.update(
                statement, merchant.getId(), merchant.getName(),
                merchant.getCnpj(), merchant.getEmail(), merchant.getActive());

        return find(merchant.getId()).get();
    }

    @Override
    public Merchant update(Merchant merchant) {
        String statement = "UPDATE merchant SET name = ?, cnpj = ?, email = ?, active = ? WHERE id = ?";
        this.jdbcTemplate.update(
                statement,
                merchant.getName(),
                merchant.getCnpj(),
                merchant.getEmail(),
                merchant.getActive()
        );
        return find(merchant.getId()).get();
    }

    @Override
    public Page<Merchant> find(PageRequest page) {

        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" LIMIT ?")
                .append(" OFFSET ?");

        ArrayList<Integer> arguments = new ArrayList<>();
        arguments.add(page.getSize());
        arguments.add(page.offset());

        Set<Merchant> merchants = this.jdbcTemplate.query(statement.toString(),
                arguments.toArray(), merchantExtractor);

        return new Page(
                collectList(merchants),
                page.getPage(),
                page.getSize(),
                executeCountQuery()
        );
    }

    @Override
    public Optional<Merchant> findByCnpj(String cnpj) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE cnpj = ?");

        return this.jdbcTemplate.query(statement.toString(), new String[]{cnpj},
                merchantExtractor).stream().findFirst();
    }

    @Override
    public Optional<Merchant> findByEmail(String email) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE email = ?");

        return this.jdbcTemplate.query(statement.toString(), new String[]{email},
                merchantExtractor).stream().findFirst();
    }

    private List<Merchant> collectList(Set<Merchant> merchants) {
        if (merchants.isEmpty()) {
            return emptyList();
        } else {
            return merchants.stream().collect(Collectors.toList());
        }
    }

    private Integer executeCountQuery() {
        String countStatement = "SELECT count(*) AS total FROM merchant";
        return this.jdbcTemplate.queryForObject(countStatement, Integer.class);
    }

}
