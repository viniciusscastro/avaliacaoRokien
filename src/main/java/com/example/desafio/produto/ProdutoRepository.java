package com.example.desafio.produto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
//    @Query(Value = "select p.nome ,pn.nota from produto p \n" +
//            "inner join produto_notas pn\n" +
//            "on p.id = pn.produto_id" +
//            "order by pn.nota;", nativeQuery = true)
//    List<Produto> findTop10Notas();


}

