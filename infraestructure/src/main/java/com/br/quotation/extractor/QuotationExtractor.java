package com.br.quotation.extractor;

import java.util.Set;
import java.util.HashSet;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.SQLException;
import com.br.quotation.entities.Product;
import com.br.quotation.entities.Merchant;
import com.br.quotation.entities.Provider;
import com.br.quotation.entities.Quotation;
import com.br.quotation.entities.QuotationStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Robson
 */
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
        return new Quotation(
                resultSet.getLong("id"),
                resultSet.getDouble("price"),
                resultSet.getObject("product", Product.class),
                resultSet.getObject("merchant", Merchant.class),
                resultSet.getObject("provider", Provider.class),
                resultSet.getObject("deadLine", LocalDate.class),
                resultSet.getObject("status", QuotationStatus.class)
        );
    }

}
