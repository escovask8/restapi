package com.crud.restapi;

import java.util.List;
import com.crud.restapi.entities.Contatos;
import com.crud.restapi.repository.ContatosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoRest {
  
    @Autowired
    private ContatosRepository repositorio;

@GetMapping
    public List<Contatos>listar(){
        return repositorio.findAll();
    }

 @PostMapping   
    public void salvar(@RequestBody Contatos contato){
        repositorio.save(contato);
    }

@PutMapping
    public void alterar(@RequestBody Contatos contato){
        if(contato.getId()>0)
        repositorio.save(contato);
    }

@DeleteMapping
    public void excluir(@RequestBody Contatos contato){
        repositorio.delete(contato);
    }
}
