package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.TransacaoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.dominio.devdisc.services.TransacaoService;

import java.util.List;

@Tag(name = "Transação")
@RequiredArgsConstructor

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @GetMapping
    @Operation(summary = "Listar todas as transações")
    public List<TransacaoDTO> listarTodas() {
        return transacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar transação por ID")
    public TransacaoDTO buscarPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Registrar uma nova transação (compra ou aluguel)")
    public TransacaoDTO registrar(@RequestBody TransacaoDTO dto) {
        return transacaoService.registrarTransacao(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover transação por ID")
    public void deletar(@PathVariable Long id) {
        transacaoService.deletar(id);
    }
}
