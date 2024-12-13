package com.william.bookstore.service;

import com.william.bookstore.domain.Categoria;
import com.william.bookstore.domain.Livro;
import com.william.bookstore.repositories.CategoriaRepository;
import com.william.bookstore.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBServise {


    final CategoriaRepository categoriaRepository;

    final LivroRepository livroRepository;

    public DBServise(CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean Cod", "Robert Martin", "Lorem ipsum dolor sit amet", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum dolor sit amet", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H,G. Wells", "Lorem ipsum dolor sit amet", cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "H. G. Wells", "Lorem ipsum dolor sit amet", cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum dolor sit amet", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
