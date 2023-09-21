package com.projetojpa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Drogarias;
import com.projetojpa.repository.DrogariasRepository;

@Service
public class DrogariasService {
    private final DrogariasRepository drogariasRepository;
    
    @Autowired
    public DrogariasService(DrogariasRepository drogariasRepository) {
        this.drogariasRepository = drogariasRepository;
    }

    public List<Drogarias> getAllDrogarias() {
        return drogariasRepository.findAll();
    }

    public Drogarias getDrogariasById(Long id) {
        Optional<Drogarias> drogarias = drogariasRepository.findById(id);
        return drogarias.orElse(null);
    }

    public Drogarias salvarProduto(Drogarias drogarias) {
        return drogariasRepository.save(drogarias);
    }

    public Drogarias updateDrogarias(Long id, Drogarias updatedDrogarias) {
        Optional<Drogarias> existingDrogarias = drogariasRepository.findById(id);
        if (existingDrogarias.isPresent()) {
            updatedDrogarias.setId(id);
            return drogariasRepository.save(updatedDrogarias);
        }
        return null;
    }

    public boolean deleteDrogarias(Long id) {
        Optional<Drogarias> existingDrogarias = drogariasRepository.findById(id);
        if (existingDrogarias.isPresent()) {
        	drogariasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}