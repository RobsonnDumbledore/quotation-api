package com.br.quotation.entities;

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

    public Quotation() {
    }

    public Quotation(Long id, Double price, Product product, Merchant merchant, Provider provider) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.merchant = merchant;
        this.provider = provider;
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
