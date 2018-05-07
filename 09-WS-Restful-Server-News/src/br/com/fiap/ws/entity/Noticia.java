package br.com.fiap.ws.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_DBE_NOTICIA")
@SequenceGenerator(name="noticia", sequenceName="SQ_T_DBE_NOTICIA", allocationSize=1)
public class Noticia {
	
	@Id
	@GeneratedValue(generator="noticia", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_titulo")
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_noticia")
	private Calendar data;
	
	@Column(name="st_noticia")
	private boolean publicado;
	
	@Column(name="ds_noticia")
	private String conteudo;
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
