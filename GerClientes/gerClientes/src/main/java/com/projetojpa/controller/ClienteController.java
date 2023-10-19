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

import com.projetojpa.entities.Cliente;
import com.projetojpa.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="Clientes", description = "API REST DE GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/cliente")

public class ClienteController {
	
private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza usuario por iD")
	public ResponseEntity<Cliente> buscaUsuarioControlId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaUsuarioId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    @Operation(summary = "Apresenta todos os clientes")
    public ResponseEntity<List<Cliente>> buscaTodosClientesControl() {
        List<Cliente> Clientes = clienteService.buscaTodosClientes();
        return ResponseEntity.ok(Clientes);
    }

	@PostMapping ("")
	@Operation(summary = "Cadastra um usuário")
	public ResponseEntity<Cliente> salvaClientesControl (@RequestBody @Valid Cliente cliente){
		Cliente salvaCliente = clienteService.salvarCliente(cliente);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alteraClienteControl (@PathVariable Long id, @RequestBody @Valid Cliente cliente){
		Cliente alteraCliente = clienteService.alterarCliente(id, cliente);
		if (alteraCliente != null) {
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
}
	@DeleteMapping("{id}")
	@Operation(summary = "Exclui um cliente")
	public ResponseEntity<Cliente> apagaClienteControl(@PathVariable Long id){
		boolean apagar = clienteService.apagarCliente(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
