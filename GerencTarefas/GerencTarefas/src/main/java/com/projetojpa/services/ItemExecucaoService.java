package com.projetojpa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.repository.ItemExecucaoRepository;


@Service
public class ItemExecucaoService {
    private final ItemExecucaoRepository itemExecucaoRepository;
    
    @Autowired
    public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
        this.itemExecucaoRepository = itemExecucaoRepository;
    }

    public List<ItemExecucao> getAllItemExecucao() {
        return itemExecucaoRepository.findAll();
    }

    public ItemExecucao getItemExecucaoById(Long id) {
        Optional<ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
        return itemExecucao.orElse(null);
    }

    public ItemExecucao salvarItemExecucao(ItemExecucao itemExecucao) {
        return itemExecucaoRepository.save(itemExecucao);
    }

    public ItemExecucao updateItemExecucao(Long id, ItemExecucao updatedItemExecucao) {
        Optional<ItemExecucao> existingItemExecucao = itemExecucaoRepository.findById(id);
        if (existingItemExecucao.isPresent()) {
            updatedItemExecucao.setId(id);
            return itemExecucaoRepository.save(updatedItemExecucao);
        }
        return null;
    }

    public boolean deleteItemExecucao(Long id) {
        Optional<ItemExecucao> existingItemExecucao = itemExecucaoRepository.findById(id);
        if (existingItemExecucao.isPresent()) {
        	itemExecucaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

	