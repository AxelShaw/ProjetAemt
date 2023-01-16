package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class EnseignantDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public EnseignantDAO() {

	}
	
	public List<Enseignant> findAll() {
		return em.createQuery("Select e from Enseignant e", Enseignant.class).getResultList();
	}

	public Enseignant add(Enseignant e) {
		if (e==null) {
			return null;
		}
		
		List<Enseignant> list = findAll();		
		for (Enseignant ens: list) {
			if (ens.getEmail().equals(e.getEmail())) {
				return null;
			}			
		}
		
		em.merge(e);
		em.detach(e);
		
		return e;
	}
	
	public Enseignant remove(Enseignant e) {
		if (e==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from Enseignant where id = ?1");	
		query.setParameter(1, e.getId()).executeUpdate();
		return e;
	}

	public Enseignant find(Enseignant e) {
		em.contains(e);
		return e;
	}

	public Enseignant findById(Integer id) {
		if (id == null) {
			return null;
		}
		Enseignant res = em.find(Enseignant.class, id);	
		em.detach(res);
		return res;
	}
	
	public Enseignant update(Enseignant e1, Enseignant e2) {
		if (e1==null || e2==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE Enseignant SET nom = ?1 WHERE email = ?2");	
		query.setParameter(1, e2.getNom());
		query.setParameter(2, e1.getEmail()).executeUpdate();
		return e1;
	}

}
