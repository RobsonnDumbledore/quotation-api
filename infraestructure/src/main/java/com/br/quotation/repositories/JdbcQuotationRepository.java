package com.br.quotation.repositories;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import static java.util.Collections.emptyList;
import org.springframework.jdbc.core.JdbcTemplate;
import com.br.quotation.extractor.QuotationExtractor;

/**
 *
 * @author Robson
 */
public class JdbcQuotationRepository implements QuotationRepository {

    private JdbcTemplate jdbcTemplate;
    private QuotationExtractor quotationExtractor;

    private String BASE_QUERY = "SELECT id,";

    public JdbcQuotationRepository(JdbcTemplate jdbcTemplate,
            QuotationExtractor quotationExtractor) {

        this.jdbcTemplate = jdbcTemplate;
        this.quotationExtractor = quotationExtractor;
    }

    @Override
    public void create(Quotation quotation) {
        String statement = "INSERT INTO quotation VALUES (?, ?, ?, ?, ?, ?)";
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
    public void update(Quotation quotation) {
        String statement = "UPDATE quotation SET price = ? WHERE id = ?";
        this.jdbcTemplate.update(
                statement,
                quotation.getPrice(),
                quotation.getId()
        );
    }

    @Override
    public Page<Quotation> find(Long providerID, Long merchantID, PageRequest page) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" LIMIT ?")
                .append(" OFFSET ?");

        ArrayList<Integer> arguments = new ArrayList<>();
        arguments.add(page.getSize());
        arguments.add(page.offset());

        Set<Quotation> quotations = this.jdbcTemplate.query(statement.toString(),
                arguments.toArray(), quotationExtractor);

        return new Page(
                collectList(quotations),
                page.getPage(),
                page.getSize(),
                executeCountQuery(providerID, merchantID)
        );
    }

    private List<Quotation> collectList(Set<Quotation> quotation) {
        if (quotation.isEmpty()) {
            return emptyList();
        } else {
            return quotation.stream().collect(Collectors.toList());
        }
    }

    private Integer executeCountQuery(Long providerID, Long merchantID) {

        String countStatement = "SELECT count(*) AS total FROM quotation WHERE id = ?, provider_id = ?, merchant_id = ?";

        return this.jdbcTemplate.queryForObject(countStatement, new Long[]{
            providerID, merchantID}, Integer.class);
    }

}
