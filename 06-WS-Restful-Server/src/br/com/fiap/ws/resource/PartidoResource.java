package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.PartidoDAO;
import br.com.fiap.ws.dao.impl.PartidoDAOImpl;
import br.com.fiap.ws.entity.Partido;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/partido")
public class PartidoResource {

	private PartidoDAO dao;

	public PartidoResource() {
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();

		dao = new PartidoDAOImpl(em); 
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Partido buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Partido> listar(){
		return dao.listar();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Partido partido,
			@Context UriInfo uri) { //Pra criar o link a URL atual

		try {
			dao.cadastrar(partido);
			dao.commit();
			UriBuilder b = uri.getAbsolutePathBuilder();
			b.path(String.valueOf(partido.getCodigo()));
			//Cria resposta 201 created
			return Response.created(b.build()).build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}	
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Partido partido, @PathParam("id") int codigo){
		
		
		try {
			partido.setCodigo(codigo);
			dao.atualizar(partido);
			dao.commit();
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("{codigo}")
	public void remover(@PathParam("codigo") int codigo) {
		try {
			dao.excluir(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
