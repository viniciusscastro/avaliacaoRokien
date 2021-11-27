package com.example.desafio.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ProdutoGranel")
public class ProdutoGranel extends Produto{

    @Column(name = "preco", nullable = false)
    private Double peso;

    private double precoPorQuilograma;

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecoPorQuiloGrama() {
        return precoPorQuilograma;
    }

    public void setPrecoPorQuilograma(Double precoPorQuilograma) {
        this.precoPorQuilograma = precoPorQuilograma;
    }
}
