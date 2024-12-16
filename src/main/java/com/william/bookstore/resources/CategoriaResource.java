package com.william.bookstore.resources;

import com.william.bookstore.domain.Categoria;
import com.william.bookstore.dtos.CategoriaDTO;
import com.william.bookstore.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDto = list.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id,  @RequestBody CategoriaDTO objDto) {
        Categoria newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }
}
