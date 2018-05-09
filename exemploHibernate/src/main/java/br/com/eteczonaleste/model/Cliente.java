package br.com.eteczonaleste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
		
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	String endereco;
	String fone;
}
