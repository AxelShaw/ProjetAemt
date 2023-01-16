package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class UtilisateurDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public UtilisateurDAO() {

	}
	
	public List<Utilisateur> findAll() {
		return em.createQuery("Select u from Utilisateur u", Utilisateur.class).getResultList();
	}

	public Utilisateur add(Utilisateur u) {
		if (u==null) {
			return null;
		}
		
		List<Utilisateur> list = findAll();		
		for (Utilisateur ens: list) {
			if (ens.getEmail().equals(u.getEmail())) {
				return null;
			}			
		}
		
		em.merge(u);
		em.detach(u);
		
		return u;
	}
	
	public Utilisateur remove(Utilisateur u) {
		if (u==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from Utilisateur where id = ?1");	
		query.setParameter(1, u.getId()).executeUpdate();
		return u;
	}

	public Utilisateur find(Utilisateur u) {
		em.contains(u);
		return u;
	}

	public Utilisateur findById(Integer id) {
		if (id == null) {
			return null;
		}
		Utilisateur res = em.find(Utilisateur.class, id);	
		em.detach(res);
		return res;
	}
	
	public Utilisateur update(Utilisateur u1, Utilisateur u2) {
		if (u1==null || u2==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE Utilisateur SET nom = ?1 WHERE email = ?2");	
		query.setParameter(1, u2.getNom());
		query.setParameter(2, u1.getEmail()).executeUpdate();
		return u1;
	}

}
