package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.UE;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class UEDAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public UEDAO() {

	}
	
	public List<UE> findAll() {
		return em.createQuery("Select e from UE e", UE.class).getResultList();
	}

	public UE add(UE e) {
		if (e==null) {
			return null;
		}
		
		em.merge(e);
		em.detach(e);
		
		return e;
	}
	
	public UE remove(UE e) {
		if (e==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from UE where id = ?1");	
		query.setParameter(1, e.getId()).executeUpdate();
		return e;
	}

	public UE find(UE e) {
		em.contains(e);
		return e;
	}

	public UE findById(Integer id) {
		if (id == null) {
			return null;
		}
		UE res = em.find(UE.class, id);	
		em.detach(res);
		return res;
	}
	
	//pas encore fait
	public UE update(UE e1, UE e2) {
		if (e1==null || e2==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE UE SET nom = ?1 WHERE email = ?2");	
		query.setParameter(1, e2.getIntitule());
		query.setParameter(2, e1.getId()).executeUpdate();
		return e1;
	}

}
