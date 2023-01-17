package be.helha.aemt.groupeA6.service;

import java.util.List;

import be.helha.aemt.groupeA6.dao.UtilisateurDAO;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("")
public class UtilisateurRS extends Application {

	@EJB
	private UtilisateurDAO dao;

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response findAll() {
		List<Utilisateur> result = dao.findAll();

		if (result == null) {
			return Response.status(Status.NO_CONTENT).entity("").build();
		}

		return Response.status(Status.OK).entity(result).build();
	}
}
