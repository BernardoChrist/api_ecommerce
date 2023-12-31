package com.residencia.ecommerce.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable long id) {
		Produto produto = produtoService.buscarProdutoPorId(id);

		
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}

	@GetMapping("/porid")
	public ResponseEntity<Produto> buscarProdutoPorId(@RequestParam long id) {
		return new ResponseEntity<>(produtoService.buscarProdutoPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Produto> salvarProdutoComFoto(@RequestPart("pdt") String strProduto, @RequestPart("img") MultipartFile arqImg) throws IOException {
		return new ResponseEntity<>(produtoService.salvarProdutoComFoto(strProduto, arqImg), HttpStatus.CREATED);
		
	}
	
//	@PostMapping
//    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
//        return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.CREATED);
//    }

	@PutMapping
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
		return new ResponseEntity<>(produtoService.atualizarProduto(produto), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarProduto(@RequestBody Produto produto) {
		if (Boolean.TRUE.equals(produtoService.deletarProduto(produto)))
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		else
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
	}
	
	
}
