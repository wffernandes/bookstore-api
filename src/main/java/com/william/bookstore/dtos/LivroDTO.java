package com.william.bookstore.dtos;

import com.william.bookstore.domain.Livro;

import java.io.Serial;
import java.io.Serializable;

public class LivroDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
