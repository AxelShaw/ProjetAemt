package be.helha.aemt.groupeA6.dao;

import java.util.List;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.exceptions.EmailDuplicateException;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.NonUniqueResultException;

@Stateless
public class EnseignantDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public EnseignantDAO() {

	}
	
	public List<Enseignant> findAll(String name) {
		if (name == null) {
			return em.createQuery("Select e from Enseignant e", Enseignant.class).getResultList();
		}
		
		return em.createQuery("Select e from Enseignant e where e.nom LIKE Concat('%',?1,'%')", Enseignant.class).setParameter(1, name).getResultList();
	}
	
	

	public Enseignant add(Enseignant e) throws NotFoundException{
		if (e==null) {
			throw new NotFoundException();
		}
		
		em.merge(e);
		em.detach(e);
		
		return e;
	}
	
	public Enseignant remove(Enseignant e) throws NotFoundException{
		if (e==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Enseignant where id = ?1");	
		query.setParameter(1, e.getId()).executeUpdate();
		em.detach(e);
		return e;
	}

	public Enseignant find(Enseignant e) {
		em.contains(e);
		return e;
	}

	public Enseignant findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
		}
		Enseignant res = em.find(Enseignant.class, id);	
		em.detach(res);
		return res;
	}
	
	
	public Enseignant update(Enseignant e) throws NotFoundException {
		if (e==null) {
			throw new NotFoundException();
		}
		Query query = em.createQuery("UPDATE Enseignant SET nom = ?1, prenom = ?2, mail = ?3, remarque = ?4 WHERE id = ?5");	
		query.setParameter(1, e.getNom());
		query.setParameter(2, e.getPrenom());
		query.setParameter(3, e.getMail());
		query.setParameter(4, e.getRemarque());
		query.setParameter(5, e.getId()).executeUpdate();
		
		em.detach(e);
		return e;
	}

}
