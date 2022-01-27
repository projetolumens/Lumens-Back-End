package ProjetoIntegrador.Lumens.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotNull(message = "O  campo é obrigatório.")
    @Size(min = 3, max = 150,  message = "O nome deve conter no mínimo 3 e no máximo 150 caracteres")
    private String nome;

    @NotNull(message = "O  campo é obrigatório.")
    @Email(message= "O campo deve ser preenchido com um E-mail válido ")
    @Size(min = 10, max = 100, message = "O E-mail deve conter no mínimo 10 e no máximo 100 caracteres")
    private String email;

    @NotNull(message = "O campo é obrigatório.")
    @Size(min = 3, max = 15, message = "A Senha deve conter no mínimo 3 e no máximo 15 caracteres")
    private String senha;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

    
    
}

