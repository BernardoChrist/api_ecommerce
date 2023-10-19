package com.residencia.ecommerce.controllers;

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
import org.springframework.web.bind.annotation.RestController;
import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategorias() {
		return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable long id) {
		Categoria categoria = categoriaService.buscarCategoriaPorId(id);

		if (categoria == null)
			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(categoria, HttpStatus.OK);
	}

	@GetMapping("/porid")
	public ResponseEntity<Categoria> buscarCategoriaPorId(@RequestParam long id) {
		return new ResponseEntity<>(categoriaService.buscarCategoriaPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.salvarCategoria(categoria), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.atualizarCategoria(categoria), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarCategoria(@RequestBody Categoria categoria) {
		if (Boolean.TRUE.equals(categoriaService.deletarCategoria(categoria)))
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		else
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
	}
}
