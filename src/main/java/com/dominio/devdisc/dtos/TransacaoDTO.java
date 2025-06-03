package com.dominio.devdisc.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransacaoDTO {
    private Long id;
    private String tipo;
    private String status;
    private DiscoDTO disco;
    private BigDecimal valor;
    private ClienteDTO cliente;
    private LocalDate dataTransacao;
    private LocalDate dataDevolucao;
}
