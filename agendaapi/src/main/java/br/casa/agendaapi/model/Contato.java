package br.casa.agendaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "contato")
public class Contato {

	
	@Id
	@Column(name = "id_contato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_contato;
	
	@NotBlank
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private String celular;
	
	
	
	public Long getId() {
		return id_contato;
	}
	public void setId(Long id) {
		this.id_contato = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
	
}
