package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.EnseignantDAO;
import be.helha.aemt.groupeA6.dao.UtilisateurDAO;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionUtilisateurEJB implements IGestionUtilisateurEJB {
	
	@EJB
	private UtilisateurDAO daoUtilisateur;

	@Override
	public List<Utilisateur> findAll() {
		return daoUtilisateur.findAll();
	}

	@Override
	public Utilisateur findById(int id) {
		return daoUtilisateur.findById(id);
	}

	@Override
	public Utilisateur add(Utilisateur u) {
		return daoUtilisateur.add(u);
	}

	@Override
	public Utilisateur remove(Utilisateur u) {
		return daoUtilisateur.remove(u);
	}

	@Override
	public Utilisateur update(Utilisateur u1, Utilisateur u2) {
		return daoUtilisateur.update(u1, u2);
	}

}
