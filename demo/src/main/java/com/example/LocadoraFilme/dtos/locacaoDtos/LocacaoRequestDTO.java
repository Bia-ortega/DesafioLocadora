package com.example.LocadoraFilme.dtos.locacaoDtos;

import jakarta.validation.constraints.NotNull;

public class LocacaoRequestDTO {

    @NotNull(message = "O id do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O id do filme é obrigatório")
    private Long filmeId;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }
}