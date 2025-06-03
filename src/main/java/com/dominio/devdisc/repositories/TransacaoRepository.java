package com.dominio.devdisc.repositories;

import com.dominio.devdisc.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
