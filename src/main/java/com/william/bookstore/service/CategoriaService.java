package com.william.bookstore.service;

import com.william.bookstore.domain.Categoria;
import com.william.bookstore.exceptions.ObjectNotFoundException;
import com.william.bookstore.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.repository = categoriaRepository;
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
