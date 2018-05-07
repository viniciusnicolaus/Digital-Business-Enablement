package br.com.fiap.ws.service;import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.NoticiaTO;

public class NoticiaService {

	private static String URL = "http://localhost:8081/09-WS-Restful-Server-News/rest/noticia";
	private Client client = Client.create();

	public void cadastrar(NoticiaTO noticia) throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, noticia);
		if(response.getStatus() != 201) {
			throw new Exception("Erro " + response.getStatus());
		}
	}

	public NoticiaTO buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));

		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}

		return response.getEntity(NoticiaTO.class);
	}

	public List<NoticiaTO> listar() throws Exception{
		WebResource resource = client.resource(URL);

		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}

		return Arrays.asList(response.getEntity(NoticiaTO[].class));
	}
	
	public void atualizar(NoticiaTO noticia) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(noticia.getCodigo()));
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, noticia);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void deletar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	

}
