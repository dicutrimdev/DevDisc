package com.dominio.devdisc.exceptions;

public class GeneroNotFoundException extends RuntimeException {
    public GeneroNotFoundException(Long id) {
        super("Gênero não encontrado com ID: " + id);
    }
}
