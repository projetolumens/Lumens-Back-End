package org.generation.Lumens.repository;

import java.util.List;

import org.generation.Lumens.model.Postagem;
import org.generation.Lumens.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Produto> findAllByRetiradaContainingIgnoreCase(String retirada);	
	
	// select * from tb_postagens where retirada like "%RETIRADA%"; 
}