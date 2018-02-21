package br.com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.loja.bo.EstoqueBO;

import br.com.fiap.config.PropertySingleton;

public class TerminalConsulta {
	
	private static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {

		log.warn("Iniciando a aplicação");
		Scanner scn = new Scanner(System.in);

		// ler o código do produto
		
		
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		EstoqueBO bo = new EstoqueBO();
		Properties prop = PropertySingleton.getInstance();
		String nomeCompleto = prop.getProperty("nome") + " " + prop.getProperty("filial");
		log.info("Recuperando dados usuários");
		int cod;
		do { 
			
			Calendar dt = Calendar.getInstance();
			System.out.println(nomeCompleto + "                DATA: " + sdf.format(dt.getTime()));
			System.out.println("**************(Zero para sair)***************");
			System.out.print("Código do produto: ");

			cod = scn.nextInt();
			
			if(cod == 0) {
				System.out.println("Tchau!");
				log.info("Usuário desligando o sistema");
				break;
			}
			
			
			log.debug("Usuário escolheu o produto de código " + cod);
			Produto produto = bo.consultarProduto(cod);
			if(produto !=null) {
				log.info("Produto encontrado");
				System.out.println("Nome do produto: " + produto.getNome() + "\n");
				System.out.println("Preço: " + df.format(produto.getPreco())+ "\n");
				System.out.println("Quantidade: " + produto.getQuantidade() + "\n");
				System.out.println("Marca: " + produto.getMarca()+ "\n");

			}else {
				System.out.println("Produto não cadastrado");
				log.error("Código de produto não existente");
			}
		}while(cod != 0);
		scn.close();
		log.warn("Finalizando a aplicação");
	}
}
