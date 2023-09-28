package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    // Métodos personalizados podem ser adicionados aqui
}

