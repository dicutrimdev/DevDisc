package com.dominio.devdisc.services;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.ClienteDTO;
import com.dominio.devdisc.entities.Cliente;
import org.springframework.stereotype.Service;
import com.dominio.devdisc.mapper.ClienteMapper;
import com.dominio.devdisc.repositories.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = getByIdOrThrow(id);
        return ClienteMapper.toDTO(cliente);
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(salvo);
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente existente = getByIdOrThrow(id);
        copyToEntity(dto, existente);
        Cliente atualizado = clienteRepository.save(existente);
        return ClienteMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        getByIdOrThrow(id);
        clienteRepository.deleteById(id);
    }

    private static void copyToEntity(ClienteDTO dto, Cliente existente) {
        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
    }

    private Cliente getByIdOrThrow(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }
}
