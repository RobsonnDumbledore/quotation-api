package com.br.quotation.utilities;

import java.util.List;

/**
 *
 * @author Robson
 * @param <T>
 */
public class Page<T> {

    private Integer total;
    private List<T> content;
    private Integer pageSize;
    private Integer pageNumber;

    public Page(List<T> content, Integer pageNumber, Integer pageSize, Integer total) {
        this.total = total;
        this.content = content;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean isLast() {
        return this.pageNumber + 1 >= this.totalPages();
    }

    public Integer totalPages() {
        if (this.content.isEmpty() && this.total == 0) {
            return 1;
        } else {
            return Double.valueOf(Math.ceil(this.total / this.pageSize)).intValue();
        }
    }

    public Integer size() {
        return this.content.size();
    }

}
