package org.generation.Lumens.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.Lumens.model.ProdutoModel;
import org.generation.Lumens.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id) {

		return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produto/{produto}")
	public ResponseEntity<List<ProdutoModel>> getByProduto(@PathVariable String produto) {

		return ResponseEntity.ok(produtoRepository.findAllByProdutoContainingIgnoreCase(produto));
	}

	@PostMapping
	public ResponseEntity<ProdutoModel> postProdutoModel(@Valid @RequestBody ProdutoModel produtoModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
	}

	@PutMapping
	public ResponseEntity<ProdutoModel> putProdutoModel(@Valid @RequestBody ProdutoModel produtoModel) {

		return produtoRepository.findById(produtoModel.getId_produto())
				.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produtoModel)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProdutoModel(@PathVariable long id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}
}


