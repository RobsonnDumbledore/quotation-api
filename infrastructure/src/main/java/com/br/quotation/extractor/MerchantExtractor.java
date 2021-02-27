package com.br.quotation.extractor;

import java.util.Set;
import java.util.HashSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.quotation.entities.Merchant;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Robson
 */
@Component
public class MerchantExtractor implements ResultSetExtractor<Set<Merchant>> {

    @Override
    public Set<Merchant> extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        Set<Merchant> merchants = new HashSet<>();

        while (resultSet.next()) {
            merchants.add(mapMerchant(resultSet));
        }

        return merchants;
    }

    private Merchant mapMerchant(ResultSet resultSet) throws SQLException {
        return new Merchant(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("cnpj"),
                resultSet.getString("email"),
                resultSet.getBoolean("active")
        );
    }

}
