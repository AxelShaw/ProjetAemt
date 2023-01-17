package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Section;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class SectionDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public SectionDAO() {

	}
	
	public List<Section> findAll() {
		return em.createQuery("Select s from Section s", Section.class).getResultList();
	}

	public Section add(Section s) {
		if (s==null) {
			return null;
		}
		
		em.merge(s);
		em.detach(s);
		
		return s;
	}
	
	public Section remove(Section s) {
		if (s==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from Section where id = ?1");	
		query.setParameter(1, s.getId()).executeUpdate();
		return s;
	}

	public Section find(Section s) {
		em.contains(s);
		return s;
	}

	public Section findById(Integer id) {
		if (id == null) {
			return null;
		}
		Section res = em.find(Section.class, id);	
		em.detach(res);
		return res;
	}

}

