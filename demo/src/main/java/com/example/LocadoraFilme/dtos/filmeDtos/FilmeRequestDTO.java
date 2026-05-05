package com.example.LocadoraFilme.dtos.filmeDtos;

import jakarta.validation.constraints.NotBlank;

public class FilmeRequestDTO {

    @NotBlank(message = "O título do filme é obrigatório")
    private String titulo;

    @NotBlank(message = "O gênero do filme é obrigatório")
    private String genero;

    @NotBlank(message = "O diretor do filme é obrigatório")
    private String diretor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}