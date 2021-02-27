package com.br.quotation.entities;

/**
 *
 * @author Robson
 */
public enum QuotationStatus {

    OPEN("OPEN"), CLOSED("CLOSED");

    private final String status;

    private QuotationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
