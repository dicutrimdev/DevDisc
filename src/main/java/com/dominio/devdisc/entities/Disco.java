package com.dominio.devdisc.entities;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_disco")
public class Disco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String banda;
    private String titulo;
    private String capaUrl;
    private Integer estoque;
    private Integer anoLancamento;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
}
