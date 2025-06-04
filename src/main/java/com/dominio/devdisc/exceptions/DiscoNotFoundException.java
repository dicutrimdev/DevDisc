package com.dominio.devdisc.exceptions;

public class DiscoNotFoundException extends RuntimeException {
    public DiscoNotFoundException(Long id) {
        super("Disco não encontrado com ID: " + id);
    }
}
