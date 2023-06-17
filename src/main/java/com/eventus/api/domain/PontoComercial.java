package com.eventus.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "ponto_comercial")
public class PontoComercial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ponto_comercial", nullable = false)
    private Long idPontoComercial;

    @Column(name = "no_ponto_comercial", nullable = false)
    private String noPontoComercial;

    @Column(name = "tipo_evento", nullable = false)
    private String tipoEvento;

}
