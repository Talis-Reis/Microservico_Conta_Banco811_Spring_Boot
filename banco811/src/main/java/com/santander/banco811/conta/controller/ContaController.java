package com.santander.banco811.conta.controller;

import com.santander.banco811.conta.payload.dto.ContaRequest;
import com.santander.banco811.conta.payload.dto.ContaResponse;
import com.santander.banco811.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping("/{cpf}")
    public ContaResponse createConta(@RequestBody ContaRequest contaRequest, @PathVariable String cpf) {
        return contaService.create(contaRequest, cpf);
    }

}
