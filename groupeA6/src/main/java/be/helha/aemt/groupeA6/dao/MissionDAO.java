package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MissionDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public MissionDAO() {

	}
	
	public List<Mission> findAll(String name) {
		if (name == null) {
			return em.createQuery("Select m from Mission m", Mission.class).getResultList();
		}
		return em.createQuery("Select m from Mission m where m.intitule LIKE Concat('%',?1,'%')", Mission.class).setParameter(1, name).getResultList();
	}

	public Mission add(Mission m) throws NotFoundException{
		if (m==null) {
			throw new NotFoundException();
		}
		
		em.merge(m);
		em.detach(m);
		
		return m;
	}
	
	public Mission remove(Mission m) throws NotFoundException{
		if (m==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Mission where id = ?1");	
		query.setParameter(1, m.getId()).executeUpdate();
		em.detach(m);
		return m;
	}

	public Mission find(Mission m) {
		em.contains(m);
		return m;
	}

	public Mission findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
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
		em.detach(m);
		return m;
	}

}

