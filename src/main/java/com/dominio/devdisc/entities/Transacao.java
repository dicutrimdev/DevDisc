package com.dominio.devdisc.entities;

import lombok.*;
import jakarta.persistence.*;
import com.dominio.devdisc.entities.enums.TipoTransacao;
import com.dominio.devdisc.entities.enums.StatusTransacao;

import java.time.LocalDate;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Disco disco;

    private BigDecimal valor;
    private LocalDate dataTransacao;
    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;
}
