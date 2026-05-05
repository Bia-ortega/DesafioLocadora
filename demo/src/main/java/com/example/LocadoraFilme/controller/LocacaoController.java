package com.example.LocadoraFilme.controller;

import com.example.LocadoraFilme.dtos.locacaoDtos.LocacaoRequestDTO;
import com.example.LocadoraFilme.dtos.locacaoDtos.LocacaoResponseDTO;
import com.example.LocadoraFilme.mapper.LocacaoMapper;
import com.example.LocadoraFilme.model.Locacao;
import com.example.LocadoraFilme.service.LocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> criarLocacao(
            @Valid @RequestBody LocacaoRequestDTO dto) {

        LocacaoResponseDTO response = locacaoService.criarLocacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<LocacaoResponseDTO> devolverFilme(
            @PathVariable Long id) {

        LocacaoResponseDTO response = locacaoService.devolverFilme(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listarLocacoes() {

        List<Locacao> locacoes = locacaoService.listarLocacoes();
        List<LocacaoResponseDTO> resposta = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            resposta.add(LocacaoMapper.toResponseDTO(locacao));
        }

        return ResponseEntity.ok(resposta);
    }
}