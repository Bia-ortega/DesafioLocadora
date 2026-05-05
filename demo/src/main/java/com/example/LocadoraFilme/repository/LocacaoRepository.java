package com.example.LocadoraFilme.repository;

import com.example.LocadoraFilme.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    boolean existsByFilmeIdAndDevolvidoFalse(Long filmeId);
}