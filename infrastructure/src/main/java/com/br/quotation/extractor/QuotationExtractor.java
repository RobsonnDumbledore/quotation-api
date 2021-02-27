package com.br.quotation.extractor;

import java.util.Set;
import java.util.HashSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.quotation.entities.Product;
import com.br.quotation.entities.Merchant;
import com.br.quotation.entities.Provider;
import com.br.quotation.entities.Quotation;
import org.springframework.stereotype.Component;
import com.br.quotation.entities.QuotationStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Robson
 */
@Component
public class QuotationExtractor implements ResultSetExtractor<Set<Quotation>> {

    @Override
    public Set<Quotation> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Set<Quotation> quotations = new HashSet<>();
        while (resultSet.next()) {
            quotations.add(map(resultSet));
        }
        return quotations;
    }

    private Quotation map(ResultSet resultSet) throws SQLException {

        Product product = new Product(resultSet.getLong("prod_id"),
                resultSet.getString("prod_name"));

        Merchant merchant = new Merchant(
                resultSet.getLong("merch_id"),
                resultSet.getString("merch_name"));

        Provider provider = new Provider(
                resultSet.getLong("prov_id"),
                resultSet.getString("prov_name"));

        return new Quotation(
                resultSet.getLong("id"),
                resultSet.getDouble("price"),
                product,
                merchant,
                provider,
                resultSet.getDate("deadline"),
                QuotationStatus.valueOf(resultSet.getString("status"))
        );
    }

}
