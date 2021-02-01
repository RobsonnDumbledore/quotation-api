package com.br.quotation.entities;

/**
 *
 * @author Robson
 */
public class Provider extends Company {

    public Provider() {
    }

    public Provider(Long id, String name, String cnpj, Boolean active) {
        super(id, name, cnpj, active);
    }

}
