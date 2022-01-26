package ProjetoIntegrador.Lumens.Controller;

import java.util.List;

import javax.validation.Valid;

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

import ProjetoIntegrador.Lumens.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*",allowedHeaders="*")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@GetMapping 
	public ResponseEntity<List<ProdutoModel>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}") 
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id) { 
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping //
	public ResponseEntity<ProdutoModel> post(@Valid @RequestBody ProdutoModel produtoModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
	}

	@PutMapping
	public ResponseEntity<ProdutoModel> put(@Valid @RequestBody ProdutoModel produtoModel) { 

		return produtoRepository.findById(produtoModel.getId())
				.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produtoModel))) 
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}
	
}
