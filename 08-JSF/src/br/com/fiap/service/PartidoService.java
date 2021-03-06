package br.com.fiap.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.PartidoTO;

public class PartidoService {
	
	private static String URL = "http://localhost:8080/06-WS-Restful-Server/rest/partido";
	private Client client = Client.create();

	public void cadastrar(PartidoTO partido) throws Exception  {
		WebResource resource = 
				client.resource(URL);
		ClientResponse response = resource 		
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, partido);
		
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
	
	public List<PartidoTO> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = 
				resource
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	
		return Arrays.asList(response.getEntity(PartidoTO[].class));
	}
	
	public void atualizar(PartidoTO partido) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(partido.getCodigo()));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, partido);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		
	}
	
	public void deletar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
}
