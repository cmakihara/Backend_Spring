package br.casa.agendaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "produto")
public class Produto {
	
	
	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_produto;
	
	@NotBlank
	private String nome;
	private String tipo;
	private String valor;
	private String seila;
	

	

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getSeila() {
		return seila;
	}
	public void setSeila(String seila) {
		this.seila = seila;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getId_produto() {
		return id_produto;
	}
	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

}
