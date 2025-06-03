package com.dominio.devdisc.mapper;

import com.dominio.devdisc.dtos.DiscoDTO;
import com.dominio.devdisc.entities.Disco;

public class DiscoMapper {

    public static DiscoDTO toDTO(Disco disco) {
        if (disco == null) return null;
        DiscoDTO dto = new DiscoDTO();
        dto.setId(disco.getId());
        dto.setTitulo(disco.getTitulo());
        dto.setBanda(disco.getBanda());
        dto.setAnoLancamento(disco.getAnoLancamento());
        dto.setEstoque(disco.getEstoque());
        dto.setCapaUrl(disco.getCapaUrl());
        dto.setGenero(GeneroMapper.toDTO(disco.getGenero()));
        return dto;
    }

    public static Disco toEntity(DiscoDTO dto) {
        if (dto == null) return null;
        Disco disco = new Disco();
        disco.setId(dto.getId());
        disco.setTitulo(dto.getTitulo());
        disco.setBanda(dto.getBanda());
        disco.setAnoLancamento(dto.getAnoLancamento());
        disco.setEstoque(dto.getEstoque());
        disco.setCapaUrl(dto.getCapaUrl());
        disco.setGenero(GeneroMapper.toEntity(dto.getGenero()));
        return disco;
    }
}
