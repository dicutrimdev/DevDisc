package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.GeneroDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.dominio.devdisc.services.GeneroService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Tag(name = "Gênero")
@RequiredArgsConstructor

@RestController
@RequestMapping("/generos")
public class GeneroController {
    private final GeneroService generoService;

    @GetMapping
    @Operation(summary = "Listar todos os gêneros")
    public List<GeneroDTO> listar() {
        return generoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gênero por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero encontrado"),
            @ApiResponse(responseCode = "404", description = "Gênero não encontrado")
    })
    public GeneroDTO buscarPorId(@PathVariable Long id) {
        return generoService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo gênero")
    public GeneroDTO salvar(@RequestBody GeneroDTO dto) {
        return generoService.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um gênero")
    public GeneroDTO atualizar(@PathVariable Long id, @RequestBody GeneroDTO dto) {
        return generoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um gênero")
    public void deletar(@PathVariable Long id) {
        generoService.deletar(id);
    }
}
