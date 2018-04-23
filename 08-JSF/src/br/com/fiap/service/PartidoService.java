package br.com.fiap.service;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.PartidoTO;

public class PartidoService {
	
	private static String URL = "http://localhost:8080/06-WS-Restful-Server/rest/partido";
	private Client client = Client.create();

	public void cadastrar(PartidoTO partido) throws Exception  {
		//Configura a URL para enviar a requisição
		WebResource resource = 
				client.resource(URL);
		
		//Chama o WS e recupera a resposta
		ClientResponse response = resource 
		//Formato dos dados que serão enviados (JSON)		
				.type(MediaType.APPLICATION_JSON)
		//Faz um POST com todos os valores do candidato
				.post(ClientResponse.class, partido);
		
		//Validar o status
		if (response.getStatus() != 201) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public PartidoTO buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		return response.getEntity(PartidoTO.class);
		
	}
}
