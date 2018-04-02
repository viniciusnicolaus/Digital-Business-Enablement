package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

public class AtualizarView {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Código: ");
		int codigo = sc.nextInt();
		System.out.print("Nome: ");
		String nome = sc.next() + sc.nextLine();
		System.out.print("Apelido: ");
		String apelido = sc.next() + sc.nextLine();
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Ficha Limpa: ");
		boolean fichaLimpa = sc.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(nome, apelido, fichaLimpa, numero);
		to.setCodigo(codigo);
		
		CandidatoService service = new CandidatoService();
		try {
			service.atualizar(to);
			System.out.println("Atualizado com sucesso!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}

}
