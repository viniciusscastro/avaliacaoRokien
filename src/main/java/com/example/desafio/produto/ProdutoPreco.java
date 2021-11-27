package com.example.desafio.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ProdutoPreco")
public class ProdutoPreco extends Produto{

    @Column(name = "preco", nullable = false)
    private Double preco;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
