package org.generation.Lumens.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	@Entity
	@Table(name = "tb_produto")
	public class Produto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull(message = "O atributo nome do produto é obrigatório.")
		@Size(min = 5, max = 100,  message = "O nome do produto deve conter no mínimo 5 e no máximo 100 caracteres")
		private String produto;

		@NotNull(message = "O atributo descricao é obrigatório.")
		@Size(min = 5, max = 100, message = "A descricao deve conter no mínimo 5 e no máximo 100 caracteres")
		private String descricao;
		 
		@NotNull(message = "O atributo foto é obrigatório.")
		@Size(min = 5, max = 1000, message = "O link da foto deve conter no mínimo 5 e no máximo 1000 caracteres")
		private String foto;
		
		@Range(min = 0)
		private float preco;
		
		/*@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Usuario usuario;*/

		
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

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		/*public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}*/

	}