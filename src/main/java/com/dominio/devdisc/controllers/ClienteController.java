package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.ClienteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.dominio.devdisc.services.ClienteService;

import java.util.List;

@Tag(name = "Cliente")
@RequiredArgsConstructor

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public List<ClienteDTO> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo cliente")
    public ClienteDTO salvar(@RequestBody ClienteDTO dto) {
        return clienteService.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente")
    public ClienteDTO atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover cliente por ID")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}
