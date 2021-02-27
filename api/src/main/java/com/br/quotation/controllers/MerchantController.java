package com.br.quotation.controllers;

import com.br.quotation.entities.Merchant;
import org.springframework.http.HttpStatus;
import com.br.quotation.utilities.PageRequest;
import com.br.quotation.utilities.PageResponse;
import com.br.quotation.usecase.merchant.FindMerchant;
import com.br.quotation.usecase.merchant.UpdateMerchant;
import com.br.quotation.usecase.merchant.CreateMerchant;
import com.br.quotation.usecase.merchant.FindAllMerchant;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.br.quotation.usecase.merchant.FindMerchantByCnpj;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.br.quotation.usecase.merchant.FindMerchantByEmail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/merchants")
public class MerchantController {

    private FindMerchant findMerchant;
    private CreateMerchant createMerchant;
    private UpdateMerchant updateMerchant;
    private FindAllMerchant findAllMerchant;
    private FindMerchantByCnpj findMerchantByCnpj;
    private FindMerchantByEmail findMerchantByEmail;

    public MerchantController(FindMerchant findMerchant,
            CreateMerchant createMerchant,
            UpdateMerchant updateMerchant,
            FindAllMerchant findAllMerchant,
            FindMerchantByCnpj findMerchantByCnpj,
            FindMerchantByEmail findMerchantByEmail) {

        this.findMerchant = findMerchant;
        this.createMerchant = createMerchant;
        this.updateMerchant = updateMerchant;
        this.findAllMerchant = findAllMerchant;
        this.findMerchantByCnpj = findMerchantByCnpj;
        this.findMerchantByEmail = findMerchantByEmail;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMerchant(@RequestBody Merchant merchant) {
        this.createMerchant.execute(merchant);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMerchant(@RequestBody Merchant merchant) {
        this.updateMerchant.execute(merchant);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<Merchant> findAllMerchant(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        PageRequest pageRequest = new PageRequest(page, size);
        return this.findAllMerchant.execute(pageRequest);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Merchant findMerchantByEmail(@RequestParam String email) {
//        return this.findMerchantByEmail.execute(email).get();
//    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Merchant findMerchantByCnpj(@RequestParam String cnpj) {
//        return this.findMerchantByCnpj.execute(cnpj).get();
//    }
    
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Merchant findMerchant(@PathVariable("id") Long merchantID) {
        return this.findMerchant.execute(merchantID).get();
    }

}
