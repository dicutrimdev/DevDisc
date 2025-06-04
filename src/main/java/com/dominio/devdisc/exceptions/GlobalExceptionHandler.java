package com.dominio.devdisc.exceptions;

import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import com.dominio.devdisc.dtos.error.CustomErrorAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            DiscoNotFoundException.class,
            GeneroNotFoundException.class,
            ClienteNotFoundException.class,
            TransacaoNotFoundException.class
    })
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, HttpServletRequest request) {
        var customErrorAttributes = new CustomErrorAttributes(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customErrorAttributes);
    }
}
