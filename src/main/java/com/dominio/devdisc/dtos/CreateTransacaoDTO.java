package com.dominio.devdisc.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransacaoDTO {
    private String tipo;
    private Long discoId;
    private Long clienteId;
    private BigDecimal valor;
}
