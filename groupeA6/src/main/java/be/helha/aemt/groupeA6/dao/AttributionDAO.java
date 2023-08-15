package be.helha.aemt.groupeA6.dao;

import java.util.ArrayList;
import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class AttributionDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public AttributionDAO() {

	}
	
	public List<Attribution> findAll() {
		return em.createQuery("Select a from Attribution a", Attribution.class).getResultList();
	}

	public Attribution add(Attribution a) throws NotFoundException{
		if (a==null) {
			throw new NotFoundException();
		}
		
		List<Attribution> list = findAll();		
		for (Attribution ens: list) {
			if (ens.getId().equals(a.getId())) {
				return null;
			}			
		}
		
		em.merge(a);
		em.detach(a);
		
		return a;
	}
	
	public Attribution remove(Attribution a) throws NotFoundException{
		if (a==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Attribution where id = ?1");	
		query.setParameter(1, a.getId()).executeUpdate();
		em.detach(a);
		return a;
	}

	public Attribution find(Attribution a) {
		em.contains(a);
		return a;
	}

	public Attribution findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
		}
		Attribution res = em.find(Attribution.class, id);	
		em.detach(res);
		return res;
	}
	
	public Attribution update(Attribution a1, Attribution a2) throws NotFoundException{
		if (a1==null || a2==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("UPDATE Attribution SET nom = ?1 WHERE email = ?2");	
		query.setParameter(1, a2.getAnneeAcademique());
		query.setParameter(2, a1.getId()).executeUpdate();
		em.detach(a1);
		em.detach(a2);
		return a1;
	}

	public List<AA> findAllAAAttribues() {
		List<AA> list = new ArrayList<>();
		
		List<Attribution> l = em.createQuery("Select a from Attribution a", Attribution.class).getResultList();
		
		for (Attribution atr: l) {
			for (AA aa: atr.getAas()) {
				if (!list.contains(aa)) {
					list.add(aa);
				}
			}
		}
		
		return list;
	}
	
	public List<Mission> findAllMissionAttribues() {
		List<Mission> list = new ArrayList<>();
		
		List<Attribution> l = em.createQuery("Select a from Attribution a", Attribution.class).getResultList();
		
		for (Attribution atr: l) {
			for (Mission mis: atr.getMissions()) {
				if (!list.contains(mis)) {
					list.add(mis);
				}
			}
		}
		
		return list;
	}
}
