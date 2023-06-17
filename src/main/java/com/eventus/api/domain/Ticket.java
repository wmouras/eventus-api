package com.eventus.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
@Accessors(chain = true)
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_ticket", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @Column(name = "qr_code", nullable = false)
    private String qrCode;

    @Column(name = "id_evento", nullable = false)
    private Long idEvento;

    @Column(name = "valor_saldo", nullable = false)
    private Double valorSaldo;

    @Column(name = "dt_alteracao", nullable = false)
    private LocalDateTime dtAlteracao;

    @Column(name = "id_usuario_alteracao")
    private Long idUsuarioAlteracao;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

}
