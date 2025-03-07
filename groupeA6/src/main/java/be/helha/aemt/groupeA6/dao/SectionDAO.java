package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class SectionDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public SectionDAO() {

	}
	
	public List<Section> findAll(String name) {

		if (name == null) {
			return em.createQuery("Select s from Section s", Section.class).getResultList();
		}
		return em.createQuery("Select s from Section s where s.nom LIKE Concat('%',?1,'%')", Section.class).setParameter(1, name).getResultList();
	}
		


	public Section add(Section s) throws NotFoundException{
		if (s==null) {
			throw new NotFoundException();
		}
		
		em.merge(s);
		em.detach(s);
		
		return s;
	}
		
	public Section remove(Section s) throws NotFoundException{
		if (s==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Section where id = ?1");	
		query.setParameter(1, s.getId()).executeUpdate();
		em.detach(s);
		return s;
	}

	public Section find(Section s) {
		em.contains(s);
		return s;
	}

	public Section findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
		}
		Section res = em.find(Section.class, id);	
		em.detach(res);
		return res;
	}

	public Section update(Section s) throws NotFoundException{
		if (s==null) {
			throw new NotFoundException();
		}
		
		Section search = find(s);
		
		Query query = em.createQuery("UPDATE Section SET nom = ?1 WHERE id = ?2");	
		query.setParameter(1, s.getNom());
		query.setParameter(2, search.getId()).executeUpdate();
		em.detach(s);
		return s;
	}

}

