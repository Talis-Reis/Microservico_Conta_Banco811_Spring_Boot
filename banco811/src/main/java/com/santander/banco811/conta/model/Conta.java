package com.santander.banco811.conta.model;

import com.santander.banco811.conta.payload.dto.ContaRequest;
import com.santander.banco811.conta.model.Enum.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "conta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "usuario_id")
    private Integer usuario;

    @Column(name = "cpf")
    private String cpf;

    public Conta(ContaRequest contaRequest){
        this.agencia = contaRequest.getAgencia();
        this.numero = contaRequest.getNumero();
        this.tipoConta = contaRequest.getTipoConta();
        this.saldo = contaRequest.getSaldo();
        this.usuario = contaRequest.getUsuario();
        this.cpf = contaRequest.getCpf();
    }

}
