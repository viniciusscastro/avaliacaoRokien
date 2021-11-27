package com.example.desafio.produto.presente;

import com.example.desafio.produto.chocolate.Chocolate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;

    /*
    As alterações do Desafio 1 vão aqui...
     */
    @GetMapping("/buscar/Todos")
    public ResponseEntity buscarTodosPresentes() {
        int totalPresentes = 0;
        for(Iterator<Presente> it = presenteService.buscarTodos().iterator(); it.hasNext(); it.next()){
            totalPresentes++;
        }
        if(totalPresentes>0) {
            return ResponseEntity.ok(presenteService.buscarTodos());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ainda não há presente cadastrado");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPresentePorId(@PathVariable Long id) {
        Optional<Presente> presente = presenteService.buscarPorId(id);
        if(presente.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(presente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Presente não encontrado");
        }
    }

    @PostMapping("/CadastrarPresente")
    public ResponseEntity criarPresente(@RequestBody Presente presente) {
        Boolean foiSalvo = presenteService.salvarPresete(presente);
        if(foiSalvo) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Presente criado com sucesso");
        }else{
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possivel criar presente, talvez ele já exista" +
                            "ou os parametros obrigatorios minimos não foram passados");
            }
    }

    @PutMapping("/AtualizarPresente")
    public ResponseEntity AtualizarPresente(@RequestBody Presente presente){
        if(presenteService.alterarPresente(presente)){
            return ResponseEntity.status(HttpStatus.OK).body("Presente salvo com sucesso.");
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possivel alterar o presente, verifique se ele existe.");
        }
    }
    @DeleteMapping("/DeletarPresente/{id}")
    public ResponseEntity deletarPresente(@PathVariable Long id){
        if(presenteService.deletarPresentePorId(id)){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Presente deletado com sucesso");

        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possivel deletar o presente");
        }
    }

}
