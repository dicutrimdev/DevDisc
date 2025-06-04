package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.DiscoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.dominio.devdisc.services.DiscoService;

import java.util.List;

@Tag(name = "Disco")
@RequiredArgsConstructor

@RestController
@RequestMapping("/discos")
public class DiscoController {
    private final DiscoService discoService;

    @GetMapping
    @Operation(summary = "Listar todos os discos")
    public List<DiscoDTO> listarTodos() {
        return discoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar disco por ID")
    public DiscoDTO buscarPorId(@PathVariable Long id) {
        return discoService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo disco")
    public DiscoDTO salvar(@RequestBody DiscoDTO dto) {
        return discoService.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar disco existente")
    public DiscoDTO atualizar(@PathVariable Long id, @RequestBody DiscoDTO dto) {
        return discoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover disco por ID")
    public void deletar(@PathVariable Long id) {
        discoService.deletar(id);
    }
}
