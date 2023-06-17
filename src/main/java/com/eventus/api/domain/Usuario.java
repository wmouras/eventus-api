package com.eventus.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuario")
@Accessors(chain = true)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "no_usuario", nullable = false)
    private String noUsuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "dt_alteracao", nullable = false)
    private LocalDateTime dtAlteracao;

    @Column(name = "dt_cadastro")
    private LocalDateTime dtCadastro;

}
