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
public class AADAO {
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public AADAO() {

	}
	
	public List<AA> findAll(String name) {
		if (name == null) {
			return em.createQuery("Select a from AA a", AA.class).getResultList();
		}
		return em.createQuery("Select a from AA a where a.intitule LIKE Concat('%',?1,'%')", AA.class).setParameter(1, name).getResultList();
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
		
		em.detach(a);
		
		return a;
	}

	public AA find(AA a) {
		em.contains(a);
		em.detach(a);
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
		
		Query query = em.createQuery("UPDATE AA SET anneeAcademique = ?1 , code = ?2 , credit = ?3, fraction = ?4, heure = ?5, heureQ1 = ?6 , heureQ2 = ?7,intitule = ?8 , nombreEtudiant = ?9, nombreGroupe = ?10  WHERE id = ?11 ");
				 	
		query.setParameter(1, a.getAnneeAcademique());
		query.setParameter(2, a.getCode());
		query.setParameter(3, a.getCredit());
		query.setParameter(4, a.getFraction());
		query.setParameter(5, a.getHeure());
		query.setParameter(6, a.getHeureQ1());
		query.setParameter(7, a.getHeureQ2());
		query.setParameter(8, a.getIntitule());
		query.setParameter(9, a.getNombreEtudiant());
		query.setParameter(10, a.getNombreGroupe());
		query.setParameter(11, a.getId()).executeUpdate();
		em.detach(a);
		return a;
	}

}
