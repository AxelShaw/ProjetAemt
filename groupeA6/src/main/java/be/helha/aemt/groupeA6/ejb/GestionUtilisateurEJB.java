package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.EnseignantDAO;
import be.helha.aemt.groupeA6.dao.UtilisateurDAO;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionUtilisateurEJB implements IGestionUtilisateurEJB {
	
	@EJB
	private UtilisateurDAO daoUtilisateur;

	@Override
	public List<Utilisateur> findAll(String name) {
		return daoUtilisateur.findAll(name);
	}

	@Override
	public Utilisateur findById(int id) throws NotFoundException {
		return daoUtilisateur.findById(id);
	}

	@Override
	public Utilisateur add(Utilisateur u) throws NotFoundException{
		return daoUtilisateur.add(u);
	}

	@Override
	public Utilisateur remove(Utilisateur u) throws NotFoundException{
		return daoUtilisateur.remove(u);
	}

	@Override
	public Utilisateur update(Utilisateur u) throws NotFoundException{
		return daoUtilisateur.update(u);
	}

	@Override
	public String getUsername(String email) throws NotFoundException {
		return daoUtilisateur.getUsername(email);
	}
	
	public int getRole(String email) {
		return daoUtilisateur.getRole(email);
	}
	
}
