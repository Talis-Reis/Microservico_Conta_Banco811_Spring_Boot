package com.santander.banco811.conta.service.Impl;

import com.santander.banco811.conta.model.Conta;
import com.santander.banco811.conta.payload.dto.ContaRequest;
import com.santander.banco811.conta.payload.dto.ContaResponse;
import com.santander.banco811.conta.payload.userExists.userExists;
import com.santander.banco811.conta.repository.ContaRepository;
import com.santander.banco811.conta.service.ContaService;
import com.santander.banco811.conta.userExists.getUserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    getUserExists getUserExists;

    @Override
    public ContaResponse create(ContaRequest contaRequest, String cpf) {
        ContaResponse retornoContaCriada = null;
        try {
            userExists userExists = getUserExists.execute(cpf.toString());
            if(userExists.getCpf() != null){
                Conta conta = new Conta();
                conta.setNumero(contaRequest.getNumero());
                conta.setAgencia(contaRequest.getAgencia());
                conta.setTipoConta(contaRequest.getTipoConta());
                conta.setSaldo(contaRequest.getSaldo());
                conta.setUsuario(userExists.getId());
                conta.setCpf(userExists.getCpf());

                retornoContaCriada = new ContaResponse(contaRepository.save(conta));
            }
        }catch(NullPointerException e) {
            System.out.println("INFELIZMENTE O CPF INFORMADO AINDA NÃO FOI CADASTRADO NA BASE DE DADOS!");
        }
        return retornoContaCriada;
    }
}
