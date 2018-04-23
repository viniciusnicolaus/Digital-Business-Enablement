package br.com.fiap.service;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.CandidatoTO;

public class CandidatoService {
	
	private static String URL = "http://localhost:8080/06-WS-Restful-Server/rest/candidato";
	private Client client = Client.create();
	
	public void deletar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	public void atualizar(CandidatoTO candidato) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(candidato.getCodigo()));
		
		ClientResponse response =
				resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, candidato);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public List<CandidatoTO> listar() throws Exception {
		
		WebResource resource = client.resource(URL);
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
				
		return Arrays.asList(response.getEntity(CandidatoTO[].class));
		
	}
	
	public CandidatoTO buscar(int codigo) throws Exception {
		WebResource resource = 
				client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = resource
				//Tipo d dados que quero receber JSON
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		//Valida se foi tudo OK
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		//Retorna o candidato
		return response.getEntity(CandidatoTO.class);
		
	}
	public void cadastrar(CandidatoTO candidato) throws Exception  {
		//Configura a URL para enviar a requisição
		WebResource resource = 
				client.resource(URL);
		
		//Chama o WS e recupera a resposta
		ClientResponse response = resource 
		//Formato dos dados que serão enviados (JSON)		
				.type(MediaType.APPLICATION_JSON)
		//Faz um POST com todos os valores do candidato
				.post(ClientResponse.class, candidato);
		
		//Validar o status
		if (response.getStatus() != 201) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
}
