package be.helha.aemt.groupeA6.service;

import java.util.List;

import be.helha.aemt.groupeA6.dao.EnseignantDAO;
import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("")
public class EnseignantRS extends Application {

	// si ok avec DAO
	@EJB
	private EnseignantDAO dao;

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response findAll() {
		List<Enseignant> result = dao.findAll();

		if (result == null) {
			return Response.status(Status.NO_CONTENT).entity("").build();
		}

		return Response.status(Status.OK).entity(result).build();
	}

	// ne fonctionne pas sur google chrome, il faut utiliser postman
	// ex: http://localhost:8080/pWebGillebert/enseignants/add/n1/e1
	@POST
	@Path("/add/{nom}/{email}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response add(@PathParam("nom") String nom, @PathParam("email") String email) {
		if (nom == null || email == null) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("").build();
		}
		
		Enseignant ens = new Enseignant(nom, email);
		Enseignant res = dao.add(ens);

		if (res == null) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("").build();
		}
		
		return Response.status(Status.CREATED).entity(res).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response delete(@PathParam("id") int id) {
		Enseignant result = dao.remove(dao.findById(id));

		if (result == null) {
			return Response.status(Status.NOT_FOUND).entity("").build();
		}

		return Response.status(Status.OK).entity(result).build();
	}
	
	@PUT
	@Path("/update/{nom}/{email}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response update(@PathParam("nom") String nom, @PathParam("email") String email) {
		
		if (nom == null || email == null) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("").build();
		}
		
		Enseignant newEns = new Enseignant(nom, email);
		Enseignant result = dao.update(newEns, newEns);

		if (result == null) {
			return Response.status(Status.NOT_FOUND).entity("").build();
		}

		return Response.status(Status.OK).entity(result).build();
	}
}
