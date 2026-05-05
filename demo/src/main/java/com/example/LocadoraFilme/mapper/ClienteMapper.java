package com.example.LocadoraFilme.mapper;

import com.example.LocadoraFilme.dtos.clienteDtos.ClienteRequestDTO;
import com.example.LocadoraFilme.dtos.clienteDtos.ClienteResponseDTO;
import com.example.LocadoraFilme.model.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public static ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        return dto;
    }
}
