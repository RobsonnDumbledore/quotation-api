package com.br.quotation.entities;

/**
 *
 * @author Robson
 */
public class Merchant extends Company {

    public Merchant() {
    }

    public Merchant(Long id, String name, String cnpj,
            String email, Boolean active) {

        super(id, name, cnpj, email, active);
    }

}
