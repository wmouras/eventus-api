package com.eventus.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil")
@Accessors(chain = true)
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_perfil", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "tipo_perfil")
    private String tipoPerfil;

    @Column(name = "no_perfil", nullable = false)
    private String noPerfil;

}
