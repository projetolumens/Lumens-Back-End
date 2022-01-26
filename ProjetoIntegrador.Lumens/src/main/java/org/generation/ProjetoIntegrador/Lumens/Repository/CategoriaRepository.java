package org.generation.ProjetoIntegrador.Lumens.Repository;


import java.util.List;

import org.generation.ProjetoIntegrador.Lumens.Model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

	public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
		public List<CategoriaModel> findAllByGrupoDescarteContainingIgnoreCase(String grupoDescarte);

}

