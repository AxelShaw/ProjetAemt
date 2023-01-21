package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.EnseignantDAO;
import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Stateless
public class GestionEnseignantEJB implements IGestionEnseignantEJB {

	@EJB
	private EnseignantDAO daoEnseignant;
	
	@Override
	public List<Enseignant> findAll(String name) {
		return daoEnseignant.findAll(name);
	}
	
	@Override
	public Enseignant findById(int id) {
		return daoEnseignant.findById(id);
	}
	

	@Override
	public Enseignant add(Enseignant e) {
		return daoEnseignant.add(e);
	}

	@Override
	public Enseignant remove(Enseignant e) {
		return daoEnseignant.remove(e);
	}
	
	@Override
	public Enseignant update(Enseignant e) {
		return daoEnseignant.update(e);
	}
}
