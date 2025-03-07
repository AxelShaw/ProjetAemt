package be.helha.aemt.groupeA6.dao;

import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class DepartementDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public DepartementDAO() {

	}
	
	public List<Departement> findAll() {
		return em.createQuery("Select d from Departement d", Departement.class).getResultList();
	}

	public Departement add(Departement d) throws NotFoundException{
		if (d==null) {
			throw new NotFoundException();
		}
		
		em.merge(d);
		em.detach(d);
		
		return d;
	}
	
	public Departement remove(Departement d) throws NotFoundException{
		if (d==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Enseignant where id = ?1");	
		query.setParameter(1, d.getId()).executeUpdate();
		em.detach(d);
		return d;
	}

	public Departement find(Departement d) {
		em.contains(d);
		return d;
	}

	public Departement findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
		}
		Departement res = em.find(Departement.class, id);	
		em.detach(res);
		return res;
	}

}