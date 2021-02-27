package com.br.quotation.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Robson
 */
public class Quotation {

    private Long id;
    private Double price;
    private Date deadline;
    private Product product;
    private Merchant merchant;
    private Provider provider;
    private QuotationStatus status;

    public Quotation() {
    }

    public Quotation(
            Long id, Double price, Product product, Merchant merchant, 
            Provider provider, Date deadline, QuotationStatus status) {
        
        this.id = id;
        this.price = price;
        this.product = product;
        this.merchant = merchant;
        this.provider = provider;
        this.deadline = deadline;
        this.status = status;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
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
