package org.generation.Lumens.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@NotNull (message = "O nome é obrigatório.")
	private String nomeCompleto;
	
	@ApiModelProperty(example = "email@email.com.br")
	@NotNull (message = "O atributo e-mail é obrigatório!")
	@Email(message = "O campo deve ser preenchido com um e-mail válido.")
	private String email;

	@NotNull (message = "Senha obrigatória!")
	@Size(min = 8, message = "O campo deve conter no minimo 8 caracteres.")
	private String senha;
		

	@OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuarioModel")
	private List<ProdutoModel> produtoModel;
	
	/**
	 * Construtor com atributos da Classe Usuario
	 *  Não adicionar o atributo postagem 
	 */
	public UsuarioModel(long idUsuario, String nomeCompleto, String email, String senha) {
		
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ProdutoModel> getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(List<ProdutoModel> produtoModel) {
		this.produtoModel = produtoModel;
	}

	
}
