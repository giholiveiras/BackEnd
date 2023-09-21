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

import com.projetojpa.entities.Aposento;
import com.projetojpa.services.AposentoService;

@RestController
@RequestMapping("/aposentos")
public class AposentoController {
    
    private final AposentoService aposentoService;
    
    @Autowired
    public AposentoController(AposentoService aposentoService) {
        this.aposentoService = aposentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aposento> getAposentoById(@PathVariable Long codigo) {
    	Aposento aposento = aposentoService.getAposentoById(codigo);
        if (aposento != null) {
            return ResponseEntity.ok(aposento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Aposento>> getAllAposentos() {
        List<Aposento> aposentos = aposentoService.getAllAposentos();
        return ResponseEntity.ok(aposentos);
    }

    @PostMapping("/")
    public ResponseEntity<Aposento> criarAposento(@RequestBody Aposento aposento) {
    	Aposento criarAposento = aposentoService.salvarAposento(aposento);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAposento);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Aposento> updateAposento(@PathVariable Long codigo, @RequestBody Aposento aposento) {
    	Aposento updatedAposento = aposentoService.updateAposento(codigo, aposento);
        if (updatedAposento != null) {
            return ResponseEntity.ok(updatedAposento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAposento(@PathVariable Long codigo) {
        boolean deleted = aposentoService.deleteAposento(codigo);
        if (deleted) {
        	 return ResponseEntity.ok().body("O funcionario foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       
    
}