package com.example.LocadoraFilme.mapper;

import com.example.LocadoraFilme.dtos.locacaoDtos.LocacaoResponseDTO;
import com.example.LocadoraFilme.model.Locacao;

public class LocacaoMapper {

    public static LocacaoResponseDTO toResponseDTO(Locacao locacao) {
        LocacaoResponseDTO dto = new LocacaoResponseDTO();
        dto.setId(locacao.getId());
        dto.setNomeCliente(locacao.getCliente().getNome());
        dto.setTituloFilme(locacao.getFilme().getTitulo());
        dto.setDataLocacao(locacao.getDataLocacao());
        dto.setDataDevolucao(locacao.getDataDevolucao());
        dto.setDevolvido(locacao.isDevolvido());
        return dto;
    }
}