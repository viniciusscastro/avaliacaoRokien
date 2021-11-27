package com.example.desafio;

import com.example.desafio.produto.presente.Presente;
import com.example.desafio.produto.presente.PresenteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
class PresenteTest {

    @Autowired private PresenteService presenteService;

    /*
    As alterações do Desafio 1.1 vão aqui...
     */

    @Test
    void criacaoPresente(){
        var presente = new Presente();
        presente.setId(1L);
        presente.setPreco(12.99);
        presente.setNome("Bolo");
        presenteService.salvarPresete(presente);

        assertNotNull(presente.getId());
    }

    @Test
    void alteracaoPresente(){
        var presente = new Presente();

        presente.setId(2L);
        presente.setPreco(5.55);
        presente.setNome("Bolo de baunilha");

        presenteService.salvarPresete(presente);

        var idOriginal = presente.getId();

        presente.setNome("Bolo de baunilha e chocolate");

        presenteService.alterarPresente(presente);

        assertEquals(idOriginal, presente.getId());
        assertEquals("Bolo de baunilha e chocolate",presente.getNome());

        var list = presenteService.buscarTodos();


    }

    @Test
    void deletaraPresente(){
        var presente = new Presente();
        presente.setId(3L);
        presente.setPreco(14.65);
        presente.setNome("Leite ninho");

        presenteService.salvarPresete(presente);
        assertNotNull(presenteService.buscarPorId(presente.getId()));

        presenteService.deletarPresentePorId(presente.getId());
        assertNotEquals(presenteService.buscarPorId(presente.getId()),presente);
    }

}
