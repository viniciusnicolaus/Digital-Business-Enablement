package br.com.fiap.view;

import java.util.Scanner;


import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

public class CadastarView {
	 
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.next() + sc.nextLine();
		System.out.print("Apelido: ");
		String apelido = sc.next() + sc.nextLine();
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Ficha Limpa: ");
		boolean fichaLimpa = sc.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(nome, apelido, fichaLimpa, numero);
		
		CandidatoService service = new CandidatoService();
		try {
			service.cadastrar(to);
			System.out.println("Candidato cadastrado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
