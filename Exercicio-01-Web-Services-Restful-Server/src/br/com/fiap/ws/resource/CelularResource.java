package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.CelularDAO;
import br.com.fiap.ws.dao.impl.CelularDAOImpl;
import br.com.fiap.ws.entity.Celular;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/celular")
public class CelularResource {
	
	private CelularDAO dao;
	
	public CelularResource() {
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new CelularDAOImpl(em);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Celular buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(@Context UriInfo uri, Celular cel) {
		
		try {
			dao.cadastrar(cel);
			dao.commit();
			UriBuilder b = uri.getAbsolutePathBuilder();
			b.path(String.valueOf(cel.getCodigo()));
			return Response.created(b.build()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Celular cel) {
		
		try {
			cel.setCodigo(codigo);
			dao.atualizar(cel);
			dao.commit();
		} catch (Exception e) {
			return Response.serverError().build();
		} 
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Celular> lista(){
		return dao.listar();
	}
	
	@DELETE
	@Path("{codigo}")
	public void deletar(@PathParam("codigo") int codigo) {
		try {
			dao.excluir(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
