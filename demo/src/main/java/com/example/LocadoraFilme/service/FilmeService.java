package com.example.LocadoraFilme.service;

import com.example.LocadoraFilme.dtos.filmeDtos.FilmeRequestDTO;
import com.example.LocadoraFilme.dtos.filmeDtos.FilmeResponseDTO;
import com.example.LocadoraFilme.mapper.FilmeMapper;
import com.example.LocadoraFilme.model.Filme;
import com.example.LocadoraFilme.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public FilmeResponseDTO criarFilme(FilmeRequestDTO dto) {
        Filme filme = FilmeMapper.toEntity(dto);
        Filme salvo = filmeRepository.save(filme);
        return FilmeMapper.toResponseDTO(salvo);
    }

    public List<FilmeResponseDTO> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        List<FilmeResponseDTO> dtos = new ArrayList<>();

        for (Filme filme : filmes) {
            dtos.add(FilmeMapper.toResponseDTO(filme));
        }

        return dtos;
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }
}