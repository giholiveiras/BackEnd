package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.entities.Ligacao;

@Repository
public interface LigacaoRepository extends JpaRepository<Ligacao, Long> {
    // Métodos personalizados podem ser adicionados aqui
}

