package com.william.bookstore.resources;

import com.william.bookstore.domain.Categoria;
import com.william.bookstore.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    CategoriaService service;
    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }
}
