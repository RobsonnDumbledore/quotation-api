package com.br.quotation.exceptions;

public class NotFoundException extends RuntimeException {

    private String resourceName;
    private Long id;

    public NotFoundException(String resourceName, Long id) {
        super("Resource not found!");
        this.resourceName = resourceName;
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
