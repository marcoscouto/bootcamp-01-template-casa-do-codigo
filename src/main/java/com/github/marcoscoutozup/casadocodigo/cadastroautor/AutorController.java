package com.github.marcoscoutozup.casadocodigo.cadastroautor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Autor cadastrarAutor(@RequestBody @Valid AutorDTO dto){
        Autor autor = dto.toModel();
        entityManager.persist(autor);
        return autor;
    }

}
