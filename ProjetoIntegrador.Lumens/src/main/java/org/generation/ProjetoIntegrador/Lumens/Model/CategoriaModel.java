package org.generation.ProjetoIntegrador.Lumens.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo produto é obrigatório.")
    @Size(min = 5, max = 100,  message = "O nome deve conter no mínimo 5 e no máximo 100 caracteres")
    private String produto;

    @NotNull(message = "O atributo descricao é obrigatório.")
    @Size(min = 5, max = 100, message = "A descrição deve conter no mínimo 5 e no máximo 100 caracteres")
    private String descricao;
  

    @NotNull(message = "O atributo setor é obrigatório.")
    @Size(min = 5, max = 10, message = "o setor deve conter no mínimo 5 e no máximo 100 caracteres")
    private String setor;
    
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}