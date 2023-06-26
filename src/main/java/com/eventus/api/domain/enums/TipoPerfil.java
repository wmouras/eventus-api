package com.eventus.api.domain.enums;

import lombok.Getter;

@Getter
public enum TipoPerfil {

    USER(1), ADMIN(2);
    final int valor;


    TipoPerfil(int tipoValor){
        this.valor = tipoValor;
    }

}
