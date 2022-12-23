package br.com.banco.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	@Column(name = "id_conta")
	private long id;
	private String nomeResponsavel;

	public Conta() {

	}

	public Conta(long id, String nomeResponsavel) {
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

}
