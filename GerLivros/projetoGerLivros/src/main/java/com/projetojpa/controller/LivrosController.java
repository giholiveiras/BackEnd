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

import com.projetojpa.entities.Livros;
import com.projetojpa.services.LivrosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="livros", description = "API REST DE GERENCIAMENTO DE LIVROS")
@RestController
@RequestMapping("/livros")

public class LivrosController {
private final LivrosService livrosService;
	
	@Autowired
	public LivrosController(LivrosService livrosService) {
		this.livrosService = livrosService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza livro por iD")
	public ResponseEntity<Livros> buscaLivrosControlId(@PathVariable Long id) {
		Livros livros = livrosService.buscaLivrosId(id);
        if (livros != null) {
            return ResponseEntity.ok(livros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    @Operation(summary = "Apresenta todos os livros")
    public ResponseEntity<List<Livros>> buscaTodosLivrosControl() {
        List<Livros> Livros = livrosService.buscaTodosLivros();
        return ResponseEntity.ok(Livros);
    }

	@PostMapping ("")
	@Operation(summary = "Cadastra um livro")
	public ResponseEntity<Livros> salvaLivrosControl (@RequestBody @Valid Livros livros){
		Livros salvaLivros = livrosService.salvarLivros(livros);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvaLivros);
}
	@PutMapping("/{id}")
	public ResponseEntity<Livros> alteraLivrosControl (@PathVariable Long id, @RequestBody @Valid Livros livros){
		Livros alteraLivros = livrosService.alterarLivros(id, livros);
		if (alteraLivros != null) {
			return ResponseEntity.ok(livros);
		}
		else {
			return ResponseEntity.notFound().build();
		}
}
	@DeleteMapping("{id}")
	@Operation(summary = "Exclui um livro")
	public ResponseEntity<Livros> apagaLivrosControl(@PathVariable Long id){
		boolean apagar = livrosService.apagarLivros(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
