package com.br.quotation.extractor;

import java.util.Set;
import java.util.HashSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.quotation.entities.Provider;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Robson
 */
public class ProviderExtractor implements ResultSetExtractor<Set<Provider>> {

    @Override
    public Set<Provider> extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        Set<Provider> merchants = new HashSet<>();

        while (resultSet.next()) {
            merchants.add(mapProvider(resultSet));
        }

        return merchants;
    }

    private Provider mapProvider(ResultSet resultSet) throws SQLException {
        return new Provider(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("cnpj"),
                resultSet.getString("email"),
                resultSet.getBoolean("active")
        );
    }

}
