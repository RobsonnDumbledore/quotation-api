package com.br.quotation.repositories;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.inject.Inject;
import java.util.stream.Collectors;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import static java.util.Collections.emptyList;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.br.quotation.extractor.QuotationExtractor;

/**
 *
 * @author Robson
 */
@Repository
public class JdbcQuotationRepository implements QuotationRepository {

    private JdbcTemplate jdbcTemplate;
    private QuotationExtractor quotationExtractor;

    private static final String BASE_QUERY = " SELECT quot.*, ";

    @Inject
    public JdbcQuotationRepository(JdbcTemplate jdbcTemplate,
            QuotationExtractor quotationExtractor) {

        this.jdbcTemplate = jdbcTemplate;
        this.quotationExtractor = quotationExtractor;
    }

    @Override
    public void create(Quotation quotation) {
        String statement = "INSERT INTO quotation(price, product_id, merchant_id, "
                + "provider_id, deadline, status) VALUES(?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(
                statement,
                quotation.getPrice(),
                quotation.getProduct().getId(),
                quotation.getMerchant().getId(),
                quotation.getProvider().getId(),
                quotation.getDeadline(),
                quotation.getStatus().getStatus()
        );
    }

    @Override
    public void update(Quotation quotation) {
        String statement = "UPDATE quotation SET "
                + "price = ?, product_id = ?, merchant_id = ?, provider_id = ?, "
                + "deadline = ?, status = ? WHERE id = ?";
        this.jdbcTemplate.update(
                statement,
                quotation.getPrice(),
                quotation.getProduct().getId(),
                quotation.getMerchant().getId(),
                quotation.getProvider().getId(),
                quotation.getDeadline(),
                quotation.getStatus()
        );
    }

    @Override
    public Page<Quotation> find(Long providerID, Long merchantID, PageRequest page) {

        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append("merch.id as ").append("merch_id, ")
                .append("merch.name as ").append("merch_name, ")
                .append("prod.id as ").append("prod_id, ")
                .append("prod.name as ").append("prod_name, ")
                .append("prov.id as ").append("prov_id, ")
                .append("prov.name as ").append("prov_name ")
                .append("FROM quotation quot ")
                .append("INNER JOIN product prod ON prod.id = quot.product_id ")
                .append("INNER JOIN provider prov ON prov.id = quot.provider_id ")
                .append("INNER JOIN merchant merch ON merch.id = quot.merchant_id ")
                .append("WHERE merch.id = ? AND prov.id = ? ")
                .append("LIMIT ?")
                .append("OFFSET ?");

        ArrayList<Long> arguments = new ArrayList<>();
        arguments.add(merchantID);
        arguments.add(providerID);
        arguments.add(Long.parseLong(page.getSize().toString()));
        arguments.add(Long.parseLong((page.offset()).toString()));

        Set<Quotation> quotations = this.jdbcTemplate.query(
                statement.toString(),
                arguments.toArray(), quotationExtractor);

        return new Page(
                collectList(quotations),
                page.getPage(),
                page.getSize(),
                executeCountQuery(providerID, merchantID)
        );

    }

    private List<Quotation> collectList(Set<Quotation> quotations) {
        if (quotations.isEmpty()) {
            return emptyList();
        } else {
            return quotations.stream().collect(Collectors.toList());
        }
    }

    private Integer executeCountQuery(Long providerID, Long merchantID) {
        String countStatement = "SELECT count(*) AS total FROM quotation "
                + "WHERE merchant_id = ? AND provider_id = ? ";
        Integer count = this.jdbcTemplate.queryForObject(countStatement,
                new Object[]{merchantID, providerID}, Integer.class);
        return count;
    }

}
