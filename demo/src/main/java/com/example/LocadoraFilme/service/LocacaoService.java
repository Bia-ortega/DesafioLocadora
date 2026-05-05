package com.example.LocadoraFilme.service;

import com.example.LocadoraFilme.dtos.locacaoDtos.LocacaoRequestDTO;
import com.example.LocadoraFilme.dtos.locacaoDtos.LocacaoResponseDTO;
import com.example.LocadoraFilme.mapper.LocacaoMapper;
import com.example.LocadoraFilme.model.Cliente;
import com.example.LocadoraFilme.model.Filme;
import com.example.LocadoraFilme.model.Locacao;
import com.example.LocadoraFilme.repository.LocacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteService clienteService;
    private final FilmeService filmeService;

    public LocacaoService(LocacaoRepository locacaoRepository,
                          ClienteService clienteService,
                          FilmeService filmeService) {
        this.locacaoRepository = locacaoRepository;
        this.clienteService = clienteService;
        this.filmeService = filmeService;
    }

    public LocacaoResponseDTO criarLocacao(LocacaoRequestDTO dto) {

        Cliente cliente = clienteService.buscarPorId(dto.getClienteId());
        Filme filme = filmeService.buscarPorId(dto.getFilmeId());

        boolean filmeAlugado = locacaoRepository
                .existsByFilmeIdAndDevolvidoFalse(filme.getId());

        if (filmeAlugado) {
            throw new RuntimeException("Este filme já está alugado");
        }

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setFilme(filme);
        locacao.setDataLocacao(LocalDate.now());
        locacao.setDevolvido(false);

        Locacao salva = locacaoRepository.save(locacao);
        return LocacaoMapper.toResponseDTO(salva);
    }

    public LocacaoResponseDTO devolverFilme(Long locacaoId) {

        Locacao locacao = locacaoRepository.findById(locacaoId)
                .orElseThrow(() -> new RuntimeException("Locação não encontrada"));

        locacao.setDevolvido(true);
        locacao.setDataDevolucao(LocalDate.now());

        Locacao salva = locacaoRepository.save(locacao);
        return LocacaoMapper.toResponseDTO(salva);
    }

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }

}