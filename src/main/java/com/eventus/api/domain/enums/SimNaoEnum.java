package com.eventus.api.domain.enums;

import lombok.Getter;

@Getter
public enum SimNaoEnum {

    SIM("S"), NAO("S");

    private final String valor;

    SimNaoEnum(String valor) {
        this.valor = valor;
    }

}
