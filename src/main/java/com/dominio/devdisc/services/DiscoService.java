package com.dominio.devdisc.services;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.DiscoDTO;
import com.dominio.devdisc.entities.Disco;
import org.springframework.stereotype.Service;
import com.dominio.devdisc.mapper.DiscoMapper;
import com.dominio.devdisc.repositories.DiscoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscoService {
    private final DiscoRepository discoRepository;

    public List<DiscoDTO> listarTodos() {
        return discoRepository.findAll()
                .stream()
                .map(DiscoMapper::toDTO)
                .toList();
    }

    public DiscoDTO buscarPorId(Long id) {
        Disco disco = getByIdOrThrow(id);
        return DiscoMapper.toDTO(disco);
    }

    public DiscoDTO salvar(DiscoDTO dto) {
        Disco disco = DiscoMapper.toEntity(dto);
        Disco salvo = discoRepository.save(disco);
        return DiscoMapper.toDTO(salvo);
    }

    public DiscoDTO atualizar(Long id, DiscoDTO dto) {
        Disco existente = getByIdOrThrow(id);
        copyToEntity(dto, existente);
        Disco atualizado = discoRepository.save(existente);
        return DiscoMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        getByIdOrThrow(id);
        discoRepository.deleteById(id);
    }

    private static void copyToEntity(DiscoDTO dto, Disco existente) {
        existente.setTitulo(dto.getTitulo());
        existente.setBanda(dto.getBanda());
        existente.setAnoLancamento(dto.getAnoLancamento());
        existente.setEstoque(dto.getEstoque());
        existente.setCapaUrl(dto.getCapaUrl());
        existente.setGenero(DiscoMapper.toEntity(dto).getGenero());
    }

    private Disco getByIdOrThrow(Long id) {
        return discoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Disco não encontrado com ID: " + id)
        );
    }
}
