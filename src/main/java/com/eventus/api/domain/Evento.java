package com.eventus.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "evento")
@Accessors(chain = true)
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_evento", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @Column(name = "no_evento", nullable = false)
    private String noEvento;

    @Column(name = "ds_evento", nullable = false)
    private String dsEvento;

    @Column(name = "dt_evento")
    private LocalDateTime dtEvento;

}
