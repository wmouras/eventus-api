package com.eventus.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produto")
@Accessors(chain = true)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_produto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "no_produto", nullable = false)
    private String noProduto;

    @Column(name = "valor_produto", nullable = false)
    private Double valorProduto;

    @Column(name = "ds_produto")
    private String dsProduto;

}
