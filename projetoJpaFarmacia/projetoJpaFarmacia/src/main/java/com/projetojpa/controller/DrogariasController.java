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

import com.projetojpa.entities.Drogarias;
import com.projetojpa.services.DrogariasService;

@RestController
@RequestMapping("/drogarias")
public class DrogariasController {
    
    private final DrogariasService drogariasService;
    
    @Autowired
    public DrogariasController(DrogariasService drogariasService) {
        this.drogariasService = drogariasService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drogarias> getProductById(@PathVariable Long id) {
    	Drogarias drogarias = drogariasService.getDrogariasById(id);
        if (drogarias != null) {
            return ResponseEntity.ok(drogarias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Drogarias>> getAllDrogarias() {
        List<Drogarias> drogarias = drogariasService.getAllDrogarias();
        return ResponseEntity.ok(drogarias);
    }

    @PostMapping("/")
    public ResponseEntity<Drogarias> criarDrogarias(@RequestBody Drogarias drogarias) {
    	Drogarias criarDrogarias = drogariasService.salvarProduto(drogarias);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarDrogarias);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Drogarias> updateDrogarias(@PathVariable Long id, @RequestBody Drogarias drogarias) {
    	Drogarias updatedDrogarias = drogariasService.updateDrogarias(id, drogarias);
        if (updatedDrogarias != null) {
            return ResponseEntity.ok(updatedDrogarias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrogarias(@PathVariable Long id) {
        boolean deleted = drogariasService.deleteDrogarias(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       
    
}