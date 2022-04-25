package com.santander.banco811.conta.payload.userExists;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class userExists {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("dataCriacao")
    private LocalDateTime dataCriacao;

    @JsonProperty("dataAtualizacao")
    private LocalDateTime dataAtualizacao;

}
