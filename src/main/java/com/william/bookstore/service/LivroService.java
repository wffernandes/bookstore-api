package com.william.bookstore.service;

import com.william.bookstore.domain.Categoria;
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

    public Livro update(int id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return repository.save(obj);
    }
}
