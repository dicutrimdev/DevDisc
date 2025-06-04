package com.dominio.devdisc.services;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.GeneroDTO;
import com.dominio.devdisc.entities.Genero;
import org.springframework.stereotype.Service;
import com.dominio.devdisc.mapper.GeneroMapper;
import com.dominio.devdisc.repositories.GeneroRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneroService {
    private GeneroRepository generoRepository;

    public List<GeneroDTO> listarTodos() {
        return generoRepository.findAll()
                .stream()
                .map(GeneroMapper::toDTO)
                .toList();
    }

    public GeneroDTO buscarPorId(Long id) {
        Genero genero = getByIdOrThrow(id);
        return GeneroMapper.toDTO(genero);
    }

    public GeneroDTO salvar(GeneroDTO dto) {
        Genero genero = GeneroMapper.toEntity(dto);
        Genero salvo = generoRepository.save(genero);
        return GeneroMapper.toDTO(salvo);
    }

    public GeneroDTO atualizar(Long id, GeneroDTO dto) {
        Genero existente = getByIdOrThrow(id);
        copyToEntity(dto, existente);
        Genero atualizado = generoRepository.save(existente);
        return GeneroMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        getByIdOrThrow(id);
        generoRepository.deleteById(id);
    }

    private static void copyToEntity(GeneroDTO dto, Genero existente) {
        existente.setNome(dto.getNome());
    }

    private Genero getByIdOrThrow(Long id) {
        return generoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Gênero não encontrado com ID: " + id)
        );
    }
}
