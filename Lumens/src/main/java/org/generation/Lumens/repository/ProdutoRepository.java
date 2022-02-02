package org.generation.Lumens.repository;

import java.util.List;

import org.generation.Lumens.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByProdutoContainingIgnoreCase(String produto);

}
