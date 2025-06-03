package com.dominio.devdisc.mapper;

import com.dominio.devdisc.dtos.GeneroDTO;
import com.dominio.devdisc.entities.Genero;

public class GeneroMapper {

    public static GeneroDTO toDTO(Genero genero) {
        if (genero == null) return null;
        GeneroDTO dto = new GeneroDTO();
        dto.setId(genero.getId());
        dto.setNome(genero.getNome());
        return dto;
    }

    public static Genero toEntity(GeneroDTO dto) {
        if (dto == null) return null;
        Genero genero = new Genero();
        genero.setId(dto.getId());
        genero.setNome(dto.getNome());
        return genero;
    }
}
