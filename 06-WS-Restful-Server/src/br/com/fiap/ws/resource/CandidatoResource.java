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

import br.com.fiap.ws.dao.CandidatoDAO;
import br.com.fiap.ws.dao.impl.CandidatoDAOImpl;
import br.com.fiap.ws.entity.Candidato;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/candidato")
public class CandidatoResource {

	private CandidatoDAO dao;

	//Inicializa o dao no construtor
	public CandidatoResource() {
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();

		dao = new CandidatoDAOImpl(em); 
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Candidato buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidato> listar(){
		return dao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Candidato candidato,
			@Context UriInfo uri) { //Pra criar o link a URL atual

		try {
			dao.cadastrar(candidato);
			dao.commit();
			UriBuilder b = uri.getAbsolutePathBuilder();
			b.path(String.valueOf(candidato.getCodigo()));
			//Cria resposta 201 created
			return Response.created(b.build()).build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}	
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Candidato candidato, @PathParam("id") int codigo){
		
		
		try {
			candidato.setCodigo(codigo);
			dao.atualizar(candidato);
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
