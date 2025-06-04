package com.dominio.devdisc.dtos.error;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CustomErrorAttributes {
    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;
}
