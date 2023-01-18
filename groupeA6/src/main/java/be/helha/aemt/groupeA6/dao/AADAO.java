package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class AADAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public AADAO() {

	}
	
	public List<AA> findAll() {
		return em.createQuery("Select a from AA a", AA.class).getResultList();
	}

	public AA add(AA a) {
		if (a==null) {
			return null;
		}
		
		em.merge(a);
		em.detach(a);
		
		return a;
	}
	
	public AA remove(AA a) {
		if (a==null) {
			return null;
		}
		
		Query query = em.createQuery("delete from AA where id = ?1");	
		query.setParameter(1, a.getId()).executeUpdate();
		return a;
	}

	public AA find(AA a) {
		em.contains(a);
		return a;
	}

	public AA findById(Integer id) {
		if (id == null) {
			return null;
		}
		AA res = em.find(AA.class, id);	
		em.detach(res);
		return res;
	}
	
	public AA update(AA a) {
		if (a==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE AA SET anneeacademique = ?1, code = ?2, intitule = ?3, credit = ?4, heure = ?5"
				+ ", heureq1 = ?6 , heureq2, = ?7, nombreetudiant , nombregroupe = ?9, fraction = ?10  WHERE id = ?11");	
		query.setParameter(1, a.getAnneeAcademique());
		query.setParameter(2, a.getCode());
		query.setParameter(3, a.getIntitule());
		query.setParameter(4, a.getCredit());
		query.setParameter(5, a.getHeure());
		query.setParameter(6, a.getHeureQ1());
		query.setParameter(7, a.getHeureQ2());
		query.setParameter(8, a.getNombreGroupe());
		query.setParameter(9, a.getNombreEtudiant());
		query.setParameter(10, a.getFraction());
		query.setParameter(11, a.getId()).executeUpdate();
		return a;
	}

}
