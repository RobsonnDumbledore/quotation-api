package com.br.quotation.entities;

import java.time.LocalDate;

/**
 *
 * @author Robson
 */
public class Quotation {

    private Long id;
    private Double price;
    private Product product;
    private Merchant merchant;
    private Provider provider;
    private LocalDate deadline;
    private QuotationStatus status;

    public Quotation() {
    }

    public Quotation(Long id, Double price, LocalDate deadline,
            QuotationStatus status, Product product,
            Merchant merchant, Provider provider) {

        this.id = id;
        this.price = price;
        this.status = status;
        this.product = product;
        this.merchant = merchant;
        this.provider = provider;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public QuotationStatus getStatus() {
        return status;
    }

    public void setStatus(QuotationStatus status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}
