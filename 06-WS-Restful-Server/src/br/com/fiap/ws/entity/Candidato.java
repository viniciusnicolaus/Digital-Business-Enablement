package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="T_CANDIDATO")
@SequenceGenerator(name="candidato",sequenceName="SQ_T_CANDIDATO",allocationSize=1)
public class Candidato {
	
	@Id
	@Column(name="cd_candidato")
	@GeneratedValue(generator="candidato",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_candidato",length=50,nullable=false)
	private String nome;
	
	@Column(name="nm_apelido",length=50)
	private String apelido;
	
	@Column(name="nr_candidato",nullable=false)
	private int numero;
	
	@Column(name="st_ficha_limpa")
	private boolean fichaLimpa;
	
	public Candidato() {
		
	}

	public Candidato(String nome, String apelido, int numero, boolean fichaLimpa) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.numero = numero;
		this.fichaLimpa = fichaLimpa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isFichaLimpa() {
		return fichaLimpa;
	}

	public void setFichaLimpa(boolean fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
}
