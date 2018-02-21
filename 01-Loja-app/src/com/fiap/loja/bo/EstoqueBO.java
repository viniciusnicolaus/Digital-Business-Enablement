package com.fiap.loja.bo;

import br.com.fiap.loja.Produto;

public class EstoqueBO {
	
	
	public Produto consultarProduto(int codProduto) {
		Produto produto = new Produto();

		switch(codProduto) {
			case 401:
				produto.setNome("Camiseta Masculina Manga Curta Branca");
				produto.setMarca("Nike");
				produto.setQuantidade(10);
				produto.setPreco(60.00);
				break;
			case 402:
				produto.setNome("Camiseta Feminina Manga Longa Rosa");
				produto.setMarca("Adidas");
				produto.setQuantidade(12);
				produto.setPreco(35.00);
				break;
			case 0: 
				System.out.println("Aplicação fechada!");
				break;
			default:
				System.out.println("Produto não cadastrado\n");
				break;
		}
		return produto;
	}
}
