package org.generation.Lumens.repository;

import java.util.List;

import org.generation.Lumens.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List <Postagem> findAllByTituloContainingIgnoreCase(String Titulo);
	
	// select * from tb_postagens where titulo like "%titulo%"; 
}