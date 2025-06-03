package com.dominio.devdisc.mapper;

import com.dominio.devdisc.dtos.TransacaoDTO;
import com.dominio.devdisc.entities.Transacao;

public class TransacaoMapper {

    public static TransacaoDTO toDTO(Transacao transacao) {
        if (transacao == null) return null;
        TransacaoDTO dto = new TransacaoDTO();
        dto.setId(transacao.getId());
        dto.setCliente(ClienteMapper.toDTO(transacao.getCliente()));
        dto.setDisco(DiscoMapper.toDTO(transacao.getDisco()));
        dto.setDataTransacao(transacao.getDataTransacao());
        dto.setDataDevolucao(transacao.getDataDevolucao());
        dto.setTipo(transacao.getTipo().name());
        dto.setStatus(transacao.getStatus().name());
        dto.setValor(transacao.getValor());
        return dto;
    }
}
