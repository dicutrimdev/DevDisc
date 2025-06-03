package com.dominio.devdisc.repositories;

import com.dominio.devdisc.entities.Disco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscoRepository extends JpaRepository<Disco, Long> {
}
