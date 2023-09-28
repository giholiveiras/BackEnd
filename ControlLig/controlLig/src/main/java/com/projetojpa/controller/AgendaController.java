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

import com.projetojpa.entities.Agenda;
import com.projetojpa.services.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    
    private final AgendaService agendaService;
    
    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getProductById(@PathVariable Long id) {
    	Agenda agenda = agendaService.getAgendaById(id);
        if (agenda != null) {
            return ResponseEntity.ok(agenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Agenda>> getAllAgenda() {
        List<Agenda> agenda = agendaService.getAllAgenda();
        return ResponseEntity.ok(agenda);
    }

    @PostMapping("/")
    public ResponseEntity<Agenda> criarAgenda(@RequestBody Agenda agenda) {
    	Agenda criarAgenda = agendaService.salvarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAgenda);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
    	Agenda updatedAgenda = agendaService.updateAgenda(id, agenda);
        if (updatedAgenda != null) {
            return ResponseEntity.ok(updatedAgenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgenda(@PathVariable Long id) {
        boolean deleted = agendaService.deleteAgenda(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}