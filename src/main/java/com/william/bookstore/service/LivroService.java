package com.william.bookstore.service;

import com.william.bookstore.domain.Livro;
import com.william.bookstore.exceptions.ObjectNotFoundException;
import com.william.bookstore.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final CategoriaService categoriaService;

    public LivroService(LivroRepository livroRepository, LivroRepository repository, CategoriaService categoriaService) {
        this.repository = repository;
        this.categoriaService = categoriaService;
    }

    public Livro findById(int id) {
         Optional<Livro> obj  = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_Cat) {
        categoriaService.findById(id_Cat);
        return repository.findAllByCategoria(id_Cat);
    }
}
