package com.william.bookstore.service;

import com.william.bookstore.domain.Categoria;
import com.william.bookstore.dtos.CategoriaDTO;
import com.william.bookstore.exceptions.ObjectNotFoundException;
import com.william.bookstore.repositories.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.repository = categoriaRepository;
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        return repository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.william.bookstore.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados!");
        }
    }
}
