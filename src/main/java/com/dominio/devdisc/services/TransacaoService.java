package com.dominio.devdisc.services;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.entities.Disco;
import com.dominio.devdisc.entities.Cliente;
import com.dominio.devdisc.dtos.TransacaoDTO;
import com.dominio.devdisc.entities.Transacao;
import org.springframework.stereotype.Service;
import com.dominio.devdisc.mapper.TransacaoMapper;
import com.dominio.devdisc.entities.enums.TipoTransacao;
import com.dominio.devdisc.repositories.DiscoRepository;
import com.dominio.devdisc.repositories.ClienteRepository;
import com.dominio.devdisc.repositories.TransacaoRepository;

import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final DiscoRepository discoRepository;
    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;


    public List<TransacaoDTO> listarTodas() {
        return transacaoRepository.findAll()
                .stream()
                .map(TransacaoMapper::toDTO)
                .toList();
    }


    public TransacaoDTO buscarPorId(Long id) {
        Transacao transacao = getByIdOrThrow(id);
        return TransacaoMapper.toDTO(transacao);
    }


    public TransacaoDTO registrarTransacao(TransacaoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Disco disco = discoRepository.findById(dto.getDisco().getId())
                .orElseThrow(() -> new RuntimeException("Disco não encontrado"));

        if (disco.getEstoque() <= 0) {
            throw new RuntimeException("Disco sem estoque disponível");
        }

        Transacao transacao = new Transacao();
        transacao.setCliente(cliente);
        transacao.setDisco(disco);
        transacao.setTipo(TipoTransacao.valueOf(dto.getTipo()));
        transacao.setValor(dto.getValor());
        transacao.setDataTransacao(LocalDate.now());

        Transacao salva = transacaoRepository.save(transacao);
        if (transacao.getTipo() == TipoTransacao.ALUGUEL) {
            disco.setEstoque(disco.getEstoque() - 1);
            discoRepository.save(disco);
        }

        return TransacaoMapper.toDTO(salva);
    }


    public void deletar(Long id) {
        getByIdOrThrow(id);
        transacaoRepository.deleteById(id);
    }


    private Transacao getByIdOrThrow(Long id) {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada com ID: " + id));
    }
}
