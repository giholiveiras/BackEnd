package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Hospede;
import com.projetojpa.repository.HospedeRepository;

@Service
public class HospedeService {
    private final HospedeRepository hospedeRepository;
    
    @Autowired
    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    public List<Hospede> getAllHospede() {
        return hospedeRepository.findAll();
    }

    public Hospede getHospedeById(Long codigo) {
        Optional<Hospede> hospede = hospedeRepository.findById(codigo);
        return hospede.orElse(null);
    }

    public Hospede salvarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public Hospede updateHospede(Long codigo, Hospede updatedHospede) {
        Optional<Hospede> existingHospede = hospedeRepository.findById(codigo);
        if (existingHospede.isPresent()) {
            updatedHospede.setCodigo(codigo);
            return hospedeRepository.save(updatedHospede);
        }
        return null;
    }

    public boolean deleteHospede(Long codigo) {
        Optional<Hospede> existingHospede = hospedeRepository.findById(codigo);
        if (existingHospede.isPresent()) {
        	hospedeRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}