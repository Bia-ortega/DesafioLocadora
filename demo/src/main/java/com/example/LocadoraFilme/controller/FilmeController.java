package com.example.LocadoraFilme.controller;

import com.example.LocadoraFilme.dtos.filmeDtos.FilmeRequestDTO;
import com.example.LocadoraFilme.dtos.filmeDtos.FilmeResponseDTO;
import com.example.LocadoraFilme.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> criarFilme(
            @Valid @RequestBody FilmeRequestDTO dto) {

        FilmeResponseDTO response = filmeService.criarFilme(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> listarFilmes() {
        List<FilmeResponseDTO> filmes = filmeService.listarFilmes();
        return ResponseEntity.ok(filmes);
    }
}