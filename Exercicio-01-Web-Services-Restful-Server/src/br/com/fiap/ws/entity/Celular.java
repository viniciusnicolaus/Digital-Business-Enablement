package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CELULAR")
@SequenceGenerator(name="celular", sequenceName="SQ_T_CELULAR",allocationSize=1)
public class Celular {
	
	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="celular", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_marca")
	private String marca; 
	
	@Column(name="st_lancadoEsseAno")
	private boolean lancadoEsseAno;

	public Celular() {
		
	}
	
	public Celular(int codigo, String marca, boolean lancadoEsseAno) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.lancadoEsseAno = lancadoEsseAno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isLancadoEsseAno() {
		return lancadoEsseAno;
	}

	public void setLancadoEsseAno(boolean lancadoEsseAno) {
		this.lancadoEsseAno = lancadoEsseAno;
	}
}
