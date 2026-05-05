package com.example.LocadoraFilme.mapper;

import com.example.LocadoraFilme.dtos.filmeDtos.FilmeRequestDTO;
import com.example.LocadoraFilme.dtos.filmeDtos.FilmeResponseDTO;
import com.example.LocadoraFilme.model.Filme;

public class FilmeMapper {

    public static Filme toEntity(FilmeRequestDTO dto) {
        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setGenero(dto.getGenero());
        filme.setDiretor(dto.getDiretor());
        return filme;
    }

    public static FilmeResponseDTO toResponseDTO(Filme filme) {
        FilmeResponseDTO dto = new FilmeResponseDTO();
        dto.setId(filme.getId());
        dto.setTitulo(filme.getTitulo());
        dto.setGenero(filme.getGenero());
        dto.setDiretor(filme.getDiretor());
        return dto;
    }
}