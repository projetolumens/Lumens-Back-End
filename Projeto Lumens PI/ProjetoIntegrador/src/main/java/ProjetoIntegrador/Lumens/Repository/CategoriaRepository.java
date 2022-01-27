package ProjetoIntegrador.Lumens.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetoIntegrador.Lumens.Model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
	
	public List<CategoriaModel> findALLByProdutoContainingIgnoreCase (String produto);
	
}
