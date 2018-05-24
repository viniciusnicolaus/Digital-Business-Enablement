package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.entity.CelularTO;

public class CelularService {
	
	private static final String URL = "http://localhost:8081/Exercicio-01-Web-Services-Restful-Server/rest/celular"; 
	public Client client = Client.create();
	
	public void cadastrar(CelularTO cel) throws Exception {
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, cel);
		if(response.getStatus() != 201) {
			throw new Exception ("Erro " + response.getStatus());
		}
	}
	
	public CelularTO buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource
						.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		return response.getEntity(CelularTO.class);
	}
	
	public List<CelularTO> listar() throws Exception{
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		return Arrays.asList(response.getEntity(CelularTO[].class));
	}
	
	public void atualizar(CelularTO cel) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(cel.getCodigo()));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON).
				put(ClientResponse.class, cel);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void deletar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.delete(ClientResponse.class);
		if(response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
}
