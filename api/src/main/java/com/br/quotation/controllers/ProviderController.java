package com.br.quotation.controllers;

import com.br.quotation.entities.Provider;
import org.springframework.http.HttpStatus;
import com.br.quotation.usecase.provider.FindProvider;
import com.br.quotation.usecase.provider.CreateProvider;
import com.br.quotation.usecase.provider.UpdateProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.br.quotation.usecase.provider.FindProviderByCnpj;
import org.springframework.web.bind.annotation.PathVariable;
import com.br.quotation.usecase.provider.FindProviderByEmail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    private FindProvider findProvider;
    private CreateProvider createProvider;
    private UpdateProvider updateProvider;
    private FindProviderByCnpj findProviderByCnpj;
    private FindProviderByEmail findProviderByEmail;

    public ProviderController(FindProvider findProvider,
            CreateProvider createProvider,
            UpdateProvider updateProvider,
            FindProviderByCnpj findProviderByCnpj,
            FindProviderByEmail findProviderByEmail) {

        this.findProvider = findProvider;
        this.createProvider = createProvider;
        this.updateProvider = updateProvider;
        this.findProviderByCnpj = findProviderByCnpj;
        this.findProviderByEmail = findProviderByEmail;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProvider(@RequestBody Provider provider) {
        this.createProvider.execute(provider);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePovider(@RequestBody Provider provider) {
        this.updateProvider.execute(provider);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Provider findProviderByEmail(@RequestParam String email) {
//        return this.findProviderByEmail.execute(email).get();
//    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Provider findProviderByCnpj(@RequestParam String cnpj) {
//        return this.findProviderByCnpj.execute(cnpj).get();
//    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Provider findProvider(@PathVariable Long id) {
        return this.findProvider.execute(id).get();
    }

}
