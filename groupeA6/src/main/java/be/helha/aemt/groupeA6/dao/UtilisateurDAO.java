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
	
	private Role role;
	
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
	
	public Utilisateur update(Utilisateur u) {
		if (u==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE Utilisateur SET nom = ?1, prenom = ?2, email = ?3, password = ?4, departement = ?5, role = ?6 WHERE id = ?7");	
		query.setParameter(1, u.getNom());
		query.setParameter(2, u.getPrenom());
		query.setParameter(3, u.getEmail());
		query.setParameter(4, u.getPassword());
		query.setParameter(5, u.getDepartement());
		query.setParameter(6, u.getRole());
		query.setParameter(7, u.getId()).executeUpdate();
		return u;
	}
	
	public String getUsername(String email) {
		if (email == null) {
			return null;
		}
		
		String strQuery = "Select u from Utilisateur u where u.email = ?1";
		TypedQuery<Utilisateur> query = em.createQuery(strQuery, Utilisateur.class).setParameter(1, email);
		Utilisateur res = query.getResultList().get(0);
		return res.getNom() + " " + res.getPrenom();
	}

	public int getRole(String email) {
		if (email == null) {
			return 0;
		}
				
		String strQuery = "Select u from Utilisateur u where u.email = ?1";
		TypedQuery<Utilisateur> query = em.createQuery(strQuery, Utilisateur.class).setParameter(1, email);
		Utilisateur user = query.getResultList().get(0);
		
		return user.getPerm();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
