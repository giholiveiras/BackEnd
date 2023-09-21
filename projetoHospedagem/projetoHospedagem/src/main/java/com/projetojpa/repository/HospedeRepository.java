package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.entities.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    // Métodos personalizados podem ser adicionados aqui
}