package com.projetojpa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Produto;
import com.projetojpa.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	@Autowired 
	public ProdutoService (ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> buscaTodosProdutos(){
		return produtoRepository.findAll();
	}
	public Produto buscaProdutoId(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
	public Produto salvaProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//Método para alterar o dados do produto
	public Produto alterarProduto(Long id, Produto alterarProd) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			alterarProd.setId(id);
		return produtoRepository.save(alterarProd);
		}
		return null;
	}
	// Método para excluir dados
	public boolean apagarProduto (Long id) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			produtoRepository.deleteById(null);
			return true;
		}
		return false;
	}
}