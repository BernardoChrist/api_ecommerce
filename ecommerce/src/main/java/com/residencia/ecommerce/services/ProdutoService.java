package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepo;

    public List<Produto> listarProdutos() {
		return produtoRepo.findAll();
	}

	public Produto buscarProdutoPorId(Long id) {

		return produtoRepo.findById(id).orElse(null);
	}


	public Produto salvarProduto(Produto produto) {
		return produtoRepo.save(produto);
	}

	public Produto atualizarProduto(Produto produto) {
		return produtoRepo.save(produto);
	}

	public Boolean deletarProduto(Produto produto) {
		if (produto == null) {
			return false;
		}
		Produto produtoExistente = buscarProdutoPorId(produto.getIdProduto());

		if (produtoExistente == null) {
			return false;
		}

		produtoRepo.delete(produto);

		Produto produtoContinuaExistindo = buscarProdutoPorId(produto.getIdProduto());

		if (produtoContinuaExistindo == null) {
			return true;
		}

		return false;

	}
}
