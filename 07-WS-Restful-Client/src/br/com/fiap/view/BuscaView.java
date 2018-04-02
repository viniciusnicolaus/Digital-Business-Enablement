package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

public class BuscaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Código: ");
		int codigo = sc.nextInt();
		
		CandidatoService service = new CandidatoService();
		
		try {
			//Pesquisa o candidato no webservice
			CandidatoTO to = service.buscar(codigo);
			//Exibe os valores do candidato
			System.out.println(to.getNome());
			System.out.println(to.getApelido());
			System.out.println(to.getNumero());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();

	}

}
