package com.william.bookstore.resources;

import com.william.bookstore.domain.Livro;
import com.william.bookstore.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    private final LivroService service;

    public LivroResource(LivroService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable int id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
