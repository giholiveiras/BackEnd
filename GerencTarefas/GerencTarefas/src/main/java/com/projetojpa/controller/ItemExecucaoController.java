package com.projetojpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.services.ItemExecucaoService;

@RestController
@RequestMapping("/itemExecucao")
public class ItemExecucaoController {
    
    private final ItemExecucaoService itemExecucaoService;
    
    @Autowired
    public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
        this.itemExecucaoService = itemExecucaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemExecucao> getProductById(@PathVariable Long id) {
    	ItemExecucao itemExecucao = itemExecucaoService.getItemExecucaoById(id);
        if (itemExecucao != null) {
            return ResponseEntity.ok(itemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ItemExecucao>> getAllItemExecucao() {
        List<ItemExecucao> itemExecucao = itemExecucaoService.getAllItemExecucao();
        return ResponseEntity.ok(itemExecucao);
    }

    @PostMapping("/")
    public ResponseEntity<ItemExecucao> criarItemExecucao(@RequestBody ItemExecucao itemExecucao) {
    	ItemExecucao criarItemExecucao = itemExecucaoService.salvarItemExecucao(itemExecucao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarItemExecucao);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<ItemExecucao> updateTarefa(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao) {
    	ItemExecucao updatedItemExecucao = itemExecucaoService.updateItemExecucao(id, itemExecucao);
        if (updatedItemExecucao != null) {
            return ResponseEntity.ok(updatedItemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemExecucao(@PathVariable Long id) {
        boolean deleted = itemExecucaoService.deleteItemExecucao(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
