package com.example.desafio.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired private ProdutoRepository repository;

    public List<Produto> getTop10Notas() {
        /*
        As alterações do Desafio 3 vão aqui...
        Lembre-se que o tipo da lista para retorno não é Produto, e sim uma classe de DTO que deverá ser criada!
         */

        return Collections.emptyList();
    }
}
