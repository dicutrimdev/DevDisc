package com.dominio.devdisc.dtos;

import lombok.Data;

@Data
public class DiscoDTO {
    private Long id;
    private String titulo;
    private String banda;
    private Integer anoLancamento;
    private Integer estoque;
    private String capaUrl;
    private GeneroDTO genero;
}
