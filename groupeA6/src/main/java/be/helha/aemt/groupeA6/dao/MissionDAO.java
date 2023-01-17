package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class MissionDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public MissionDAO() {

	}
	
	public List<Mission> findAll() {
		return em.createQuery("Select m from Enseignant m", Mission.class).getResultList();
	}

	public Mission add(Mission m) {
		if (m==null) {
			return null;
		}
		
		em.merge(m);
		em.detach(m);
		
		return m;
	}
	
	public Mission remove(Mission m) {
		if (m==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from Mission where id = ?1");	
		query.setParameter(1, m.getId()).executeUpdate();
		return m;
	}

	public Mission find(Mission m) {
		em.contains(m);
		return m;
	}

	public Mission findById(Integer id) {
		if (id == null) {
			return null;
		}
		Mission res = em.find(Mission.class, id);	
		em.detach(res);
		return res;
	}
	
	public Mission update(Mission m) {
		if (m==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE Mission SET anneeAcademique = ?1, intitule = ?2, heures = ?3 WHERE id = ?4");	
		query.setParameter(1, m.getAnneeAcademique());
		query.setParameter(2, m.getIntitule());
		query.setParameter(3, m.getHeures());
		query.setParameter(4, m.getId()).executeUpdate();
		return m;
	}

}

