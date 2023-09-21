package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Aposento;
import com.projetojpa.repository.AposentoRepository;

@Service
public class AposentoService {
    private final AposentoRepository aposentoRepository;
    
    @Autowired
    public AposentoService(AposentoRepository aposentoRepository) {
        this.aposentoRepository = aposentoRepository;
    }

    public List<Aposento> getAllAposentos() {
        return aposentoRepository.findAll();
    }

    public Aposento getAposentoById(Long codigo) {
        Optional<Aposento> aposento = aposentoRepository.findById(codigo);
        return aposento.orElse(null);
    }

    public Aposento salvarAposento(Aposento aposento) {
        return aposentoRepository.save(aposento);
    }

    public Aposento updateAposento(Long codigo, Aposento updatedAposento) {
        Optional<Aposento> existingAposento = aposentoRepository.findById(codigo);
        if (existingAposento.isPresent()) {
            updatedAposento.setCodigo(codigo);
            return aposentoRepository.save(updatedAposento);
        }
        return null;
    }

    public boolean deleteAposento(Long codigo) {
        Optional<Aposento> existingAposento = aposentoRepository.findById(codigo);
        if (existingAposento.isPresent()) {
        	aposentoRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}