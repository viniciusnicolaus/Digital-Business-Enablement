package br.com.fiap.bean;

public class Tablet extends Produto {
	
	private String modelo;
	private String marca;
	private String sistemaOPeracional;
	private String redeMovel;
	
	
	
	public Tablet() {
		
	}
	
	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String sistemaOPeracional,
			String redeMovel) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sistemaOPeracional = sistemaOPeracional;
		this.redeMovel = redeMovel;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSistemaOPeracional() {
		return sistemaOPeracional;
	}
	public void setSistemaOPeracional(String sistemaOPeracional) {
		this.sistemaOPeracional = sistemaOPeracional;
	}
	public String getRedeMovel() {
		return redeMovel;
	}
	public void setRedeMovel(String redeMovel) {
		this.redeMovel = redeMovel;
	}
	
}
