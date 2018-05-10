package br.com.fiap.ws.entity;

public class CelularTO {
	
	private int codigo;
	
	private String marca; 
	
	private boolean lancadoEsseAno;

	public CelularTO() {
		
	}
	
	public CelularTO(int codigo, String marca, boolean lancadoEsseAno) {
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
