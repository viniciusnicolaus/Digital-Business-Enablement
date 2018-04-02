package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.service.CandidatoService;

public class RemoverView {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Código: ");
		int codigo = sc.nextInt();
		
		CandidatoService service = new CandidatoService();
		
		try {
			service.deletar(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
