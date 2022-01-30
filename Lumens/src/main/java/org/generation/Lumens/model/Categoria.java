package org.generation.Lumens.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo do nome é obrigatório.")
    @Size(min = 5, max = 100,  message = "O nome deve conter no mínimo 5 e no máximo 100 caracteres")
    private String nome;
    /*QUAL O NOME LINHA?
     * combo box
     * Lixo eletronico:
     * linha verde:computadores, tablets, notebooks, celulares, impressoras, monitores, fones de ouvido, entre outros. 
     * linha marrom:aparelhos de som, TV, equipamentos de DVD/VHS, etc. 
     * linha azul: torradeiras, batedeiras, aspiradores de pó, ventiladores, mixers, secadores de cabelo, ferramentas elétricas, calculadoras, câmeras digitais, rádios, etc. 
     * linha branca: geladeiras, freezers, máquinas de lavar, fogões, ar condicionados, microondas, etc. 
     */

    @NotNull(message = "O atributo descricao é obrigatório.")
    @Size(min = 5, max = 100, message = "A descrição deve conter no mínimo 5 e no máximo 100 caracteres")
    private String descricao;
    //grupo de de descarte referente a tais objetos 
    //descricao do produto, qual que é?notebook, geladeira?
   

    @NotNull(message = "O atributo setor é obrigatório.")
    @Size(min = 5, max = 100, message = "o setor deve conter no mínimo 1 e no máximo 100 caracteres")
    private String setor;
    // combo box
    //comercial , residencial, rural , industrial
    
    @OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnoreProperties ("categoria")
    private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
    
}
	

	