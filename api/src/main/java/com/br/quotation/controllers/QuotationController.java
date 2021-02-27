package com.br.quotation.controllers;

import com.br.quotation.entities.Quotation;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import static org.springframework.http.HttpStatus.OK;
import com.br.quotation.usecase.quotation.FindQuotation;
import com.br.quotation.usecase.quotation.UpdateQuotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.http.HttpStatus.CREATED;
import com.br.quotation.usecase.quotation.CreateQuotation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/quotations")
public class QuotationController {


    private FindQuotation findQuotation;
    private CreateQuotation createQuotation;
    private UpdateQuotation updateQuotation;

    public QuotationController(FindQuotation findQuotation,
            CreateQuotation createQuotation,
            UpdateQuotation updateQuotation) {

        this.findQuotation = findQuotation;
        this.createQuotation = createQuotation;
        this.updateQuotation = updateQuotation;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createQuotation(@RequestBody Quotation quotation) {
        this.createQuotation.execute(quotation);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void updateQuotation(@RequestBody Quotation quotation) {
        this.updateQuotation.execute(quotation);
    }

    @GetMapping
    @ResponseStatus(OK)
    public PageResponse<Quotation> findQuotation(
            @RequestBody Quotation quotation,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        PageRequest pageRequest = new PageRequest(page, size);
        return this.findQuotation.execute(
                quotation.getProvider().getId(),
                quotation.getMerchant().getId(), pageRequest
        );

    }
}
