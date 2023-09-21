package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.entities.Aposento;

@Repository
public interface AposentoRepository extends JpaRepository<Aposento, Long> {
    // Métodos personalizados podem ser adicionados aqui
}