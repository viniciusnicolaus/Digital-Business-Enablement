package com.fiap.invertario;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.ws.to.ProdutoTO;

/**
 * @author Vinícius Nicolau
 * @version 1
 * Classe de négocio que controla o estoque da aplicação
 */
public class EstoqueBO {
	
	/**
	 * 
	 * @param codigo do produto
	 * @return produto
	 * Busca o produto pelo código
	 */
	
	public ProdutoTO buscarProduto(int codProduto) throws AxisFault {
		ProdutoTO to = null;
		switch (codProduto) {
		case 401: to = new ProdutoTO(401,"Camiseta Masculina Manga Curta Branca", 
				10, 60);
			
			break;
		case 402: to = new ProdutoTO(402,"Camiseta Feminina Manga Longa Rosa",
				12, 35);
		break;
		default: if(codProduto != 401 && codProduto != 402) {
			
			throw new AxisFault("Produto não cadastrado");	
		}
	
		}
		return to;	
	}
	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(401, "Camiseta Feminina", 15, 200));
		lista.add(new ProdutoTO(402, "Camiseta Masculina", 5, 150));
		
		return lista;
	}
}
