package br.com.fiap.loja;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String nome;
	private double preco;
	private int quantidade;
	private String marca;

	public Produto(String nome, double preco, int quantidade, String marca) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
	}
	
	public Produto() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
