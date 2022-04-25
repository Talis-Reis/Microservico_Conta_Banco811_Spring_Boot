package com.santander.banco811.conta.service;

import com.santander.banco811.conta.payload.dto.ContaRequest;
import com.santander.banco811.conta.payload.dto.ContaResponse;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest, String cpf);
}
