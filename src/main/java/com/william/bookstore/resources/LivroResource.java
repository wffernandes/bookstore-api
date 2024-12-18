package com.william.bookstore.resources;

import com.william.bookstore.domain.Livro;
import com.william.bookstore.dtos.LivroDTO;
import com.william.bookstore.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat ) {
        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(LivroDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
}
