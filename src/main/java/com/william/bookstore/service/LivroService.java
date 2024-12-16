package com.william.bookstore.service;

import com.william.bookstore.domain.Livro;
import com.william.bookstore.exceptions.ObjectNotFoundException;
import com.william.bookstore.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro findById(int id) {
         Optional<Livro> obj  = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
