package com.fiap.ws.to;

/**
 * 
 * @author Vin�cius Nicolau
 * @version 1
 * Classe que armazena as informa��es de produto
 *
 */
public class ProdutoTO {
	
	
	/**
	 * C�digo do produto
	 */
	private int codigo;
	/**
	 * Descri��o do produto
	 */
	private String descricao;
	/**
	 * Quantidade do produto
	 */
	private double quantidade;
	/**
	 * Pre�o unit�rio do produto
	 */
	private int precoUnit;
	
	public ProdutoTO() {
		super();
	}
	
	public ProdutoTO(int codigo, String descricao, double quantidade, int precoUnit) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnit = precoUnit;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getPrecoUnit() {
		return precoUnit;
	}
	
	public void setPrecoUnit(int precoUnit) {
		this.precoUnit = precoUnit;
	}
}
