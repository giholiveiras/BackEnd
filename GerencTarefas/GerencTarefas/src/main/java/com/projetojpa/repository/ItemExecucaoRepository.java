package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.entities.ItemExecucao;

@Repository
public interface ItemExecucaoRepository extends JpaRepository<ItemExecucao, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
