package com.example.desafio.produto.presente;

import com.example.desafio.produto.chocolate.Chocolate;
import com.example.desafio.produto.chocolate.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository presenteRepository;

    /*
    As alterações do Desafio 1 vão aqui...

     */

    public Iterable<Presente> buscarTodos() {


        return presenteRepository.findAll();
    }

    public Optional<Presente> buscarPorId(Long id) {
        return presenteRepository.findById(id);
    }

    public Boolean salvarPresete(Presente presente) {
        if(!buscarPorId(presente.getId()).isPresent()){
            presenteRepository.save(presente);
            return true;
        }else{
            return false;
        }
    }
    public Boolean alterarPresente(Presente presente){
        if(presenteRepository.existsById(presente.getId())){
            presenteRepository.save(presente);
            return true;
        }else{
            return false;
        }
    }

    public Boolean deletarPresentePorId(Long id){
        if(presenteRepository.existsById(id)){
            presenteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }


}
