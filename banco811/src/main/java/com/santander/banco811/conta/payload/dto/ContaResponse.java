package com.santander.banco811.conta.payload.dto;

import com.santander.banco811.conta.model.Conta;
import com.santander.banco811.conta.model.Enum.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ContaResponse {

    private Integer id;
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Integer usuario;
    private String cpf;

    public ContaResponse(Conta conta){
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.tipoConta = conta.getTipoConta();
        this.saldo = conta.getSaldo();
        this.dataCriacao = conta.getDataCriacao();
        this.dataAtualizacao = conta.getDataAtualizacao();
        this.usuario = conta.getUsuario();
        this.cpf = conta.getCpf();
    }

    public static List<ContaResponse> toResponse(List<Conta> contas){
        return contas.stream().map(ContaResponse::new).collect(Collectors.toList());
    }

}
