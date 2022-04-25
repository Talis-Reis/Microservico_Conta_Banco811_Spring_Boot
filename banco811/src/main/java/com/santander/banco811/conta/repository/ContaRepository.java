package com.santander.banco811.conta.repository;

import com.santander.banco811.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
