package com.br.quotation.entities;

/**
 *
 * @author Robson
 */
public abstract class Company {

    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private Boolean active;

    public Company() {
    }

    public Company(Long id, String name, String cnpj,
            String email, Boolean active) {

        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
