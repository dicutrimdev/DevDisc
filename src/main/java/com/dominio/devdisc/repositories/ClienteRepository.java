package com.dominio.devdisc.repositories;

import com.dominio.devdisc.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
