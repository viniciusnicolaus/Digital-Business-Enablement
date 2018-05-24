package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.entity.Filme;

public class FilmeService {

	private static final String URL = "http://localhost:8081/NACServer/rest/filme";
	
	private Client client = Client.create();
	
	public void cadastrar(Filme filme) throws Exception {
		//Chamar o web service
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, filme);
		//Validar se deu certo
		if (response.getStatus() != 201) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void atualizar(Filme filme) throws Exception {
		//Chamar o web service
		WebResource resource = client.resource(URL)
				.path(String.valueOf(filme.getCodigo()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, filme);
		//Validar se deu ok!
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		ClientResponse response = resource.delete(ClientResponse.class);
		//Valida se deu ok!
		if (response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public List<Filme> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new Exception("Ero " + response.getStatus());
		}
		return Arrays.asList(response.getEntity(Filme[].class));
		
	}
}
