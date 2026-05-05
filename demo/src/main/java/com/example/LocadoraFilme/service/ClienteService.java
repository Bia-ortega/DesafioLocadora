package com.example.LocadoraFilme.service;

import com.example.LocadoraFilme.dtos.clienteDtos.ClienteRequestDTO;
import com.example.LocadoraFilme.dtos.clienteDtos.ClienteResponseDTO;
import com.example.LocadoraFilme.mapper.ClienteMapper;
import com.example.LocadoraFilme.model.Cliente;
import com.example.LocadoraFilme.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO criarCliente(ClienteRequestDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return ClienteMapper.toResponseDTO(salvo);
    }

    public List<ClienteResponseDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> dtos = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            dtos.add(ClienteMapper.toResponseDTO(cliente));
        }

        return dtos;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}