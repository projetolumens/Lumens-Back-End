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
	public class ProdutoModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_produto;
		
		@NotNull(message = "O atributo nome do produto é obrigatório.")
		@Size(min = 5, max = 100,  message = "O nome do produto deve conter no mínimo 5 e no máximo 100 caracteres")
		private String produto;

		@NotNull(message = "O atributo descricao é obrigatório.")
		@Size(min = 5, max = 100, message = "A descricao deve conter no mínimo 5 e no máximo 100 caracteres")
		private String descricao;
		 
		@NotNull(message = "O atributo foto é obrigatório.")
		@Size(min = 5, max = 100, message = "O link da foto deve conter no mínimo 5 e no máximo 100 caracteres")
		private String foto;
		
		@Range(min = 0)
		private float valor;
		
		@ManyToOne
		@JsonIgnoreProperties ("produtoModel")		
		private CategoriaModel categoriaModel;
		
		@ManyToOne
		@JsonIgnoreProperties("produtoModel")
		private UsuarioModel usuarioModel;

		public long getId_produto() {
			return id_produto;
		}

		public void setId_produto(long id_produto) {
			this.id_produto = id_produto;
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

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}

		public CategoriaModel getCategoriaModel() {
			return categoriaModel;
		}

		public void setCategoriaModel(CategoriaModel categoriaModel) {
			this.categoriaModel = categoriaModel;
		}

		public UsuarioModel getUsuarioModel() {
			return usuarioModel;
		}

		public void setUsuarioModel(UsuarioModel usuarioModel) {
			this.usuarioModel = usuarioModel;
		}


	}	