package com.dominio.devdisc.exceptions;

public class TransacaoNotFoundException extends RuntimeException {
    public TransacaoNotFoundException(Long id) {
        super("Transacao não encontrado com ID: " + id);
    }
}
