package org.generation.ProjetoIntegrador.Lumens.Repository;

import java.util.List;


import org.generation.ProjetoIntegrador.Lumens.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	public List<ProdutoModel> findAllByProdutoContainingIgnoreCase(String produto);

}
