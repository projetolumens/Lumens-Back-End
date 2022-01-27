package org.generation.Lumens.repository;

import java.util.List;

import org.generation.Lumens.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByProdutoContainingIgnoreCase(String produto);

}
