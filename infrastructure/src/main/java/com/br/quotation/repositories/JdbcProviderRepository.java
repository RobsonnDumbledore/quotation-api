package com.br.quotation.repositories;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.br.quotation.utilities.Page;
import com.br.quotation.entities.Provider;
import static java.util.Collections.emptyList;
import com.br.quotation.utilities.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.br.quotation.extractor.ProviderExtractor;

/**
 *
 * @author Robson
 */
@Repository
public class JdbcProviderRepository implements ProviderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProviderExtractor providerExtractor;

    @Inject
    public JdbcProviderRepository(JdbcTemplate jdbcTemplate,
            ProviderExtractor providerExtractor) {

        this.jdbcTemplate = jdbcTemplate;
        this.providerExtractor = providerExtractor;
    }

    private static final String BASE_QUERY = "SELECT id, name, cnpj, email, active FROM provider";

    @Override
    public Optional<Provider> find(Long id) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE id = ?");

        return this.jdbcTemplate.query(statement.toString(), new Long[]{id},
                providerExtractor).stream().findFirst();
    }

    @Override
    public void create(Provider provider) {
        String statement = "INSERT INTO provider(name, cnpj, email, active) VALUES (?, ?, ?, ?)";

        this.jdbcTemplate.update(
                statement, provider.getId(), provider.getName(),
                provider.getCnpj(), provider.getEmail(), provider.getActive());

    }

    @Override
    public void update(Provider provider) {
        String statement = "UPDATE provider SET name = ?, cnpj = ?, email = ?, active = ? WHERE id = ?";
        this.jdbcTemplate.update(
                statement,
                provider.getName(),
                provider.getCnpj(),
                provider.getEmail(),
                provider.getActive(),
                provider.getId()
        );

    }

    @Override
    public Page<Provider> find(PageRequest page) {

        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" LIMIT ?")
                .append(" OFFSET ?");

        ArrayList<Integer> arguments = new ArrayList<>();
        arguments.add(page.getSize());
        arguments.add(page.offset());

        Set<Provider> providers = this.jdbcTemplate.query(statement.toString(),
                arguments.toArray(), providerExtractor);

        return new Page(
                collectList(providers),
                page.getPage(),
                page.getSize(),
                executeCountQuery()
        );
    }

    @Override
    public Optional<Provider> findByCnpj(String cnpj) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE cnpj = ?");

        return this.jdbcTemplate.query(statement.toString(), new String[]{cnpj},
                providerExtractor).stream().findFirst();
    }

    @Override
    public Optional<Provider> findByEmail(String email) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE email = ?");

        return this.jdbcTemplate.query(statement.toString(), new String[]{email},
                providerExtractor).stream().findFirst();
    }

    private List<Provider> collectList(Set<Provider> providers) {
        if (providers.isEmpty()) {
            return emptyList();
        } else {
            return providers.stream().collect(Collectors.toList());
        }
    }

    private Integer executeCountQuery() {
        String countStatement = "SELECT count(*) AS total FROM provider";
        return this.jdbcTemplate.queryForObject(countStatement, Integer.class);
    }

}
