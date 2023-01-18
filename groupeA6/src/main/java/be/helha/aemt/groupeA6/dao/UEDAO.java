package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
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
	
	public UE update(UE ue) {
		if (ue==null) {
			return null;
		}
		
		Query query = em.createQuery("UPDATE UE SET anneeAcademique = ?1, departement = ?2, section = ?3, bloc = ?4, code = ?5, intitule = ?6, credit = ?7, aas = ?8 WHERE id = ?9");	
		query.setParameter(1, ue.getAnneeAcademique());
		query.setParameter(2, ue.getDepartement());
		query.setParameter(3, ue.getSection());
		query.setParameter(4, ue.getBloc());
		query.setParameter(5, ue.getCode());
		query.setParameter(6, ue.getIntitule());
		query.setParameter(7, ue.getCredit());
		query.setParameter(8, ue.getAas());
		query.setParameter(9, ue.getId()).executeUpdate();
		return ue;
	}
	
	//Filtre section
	public List<UE> findBySection(Section s)
	{
		Query query = em.createQuery("Select ue FROM UE ue where section_id = ?1", UE.class);
		query.setParameter(1, s.getId());
		return query.getResultList();
	}
	
	//Filtre année
	public List<UE> findByAnneeAcademique(int annee)
	{
		Query query = em.createQuery("Select ue FROM UE ue where anneeacademique = ?1", UE.class);
		query.setParameter(1, annee);
		return query.getResultList();
	}
	
	//Filtre both
	public List<UE> findBySectionAndAnneeAcademique(Section s, int annee)
	{
		Query query = em.createQuery("Select ue FROM UE ue where section_id = ?1 AND where anneeacademique = ?2", UE.class);
		query.setParameter(1, s.getId()).setParameter(2, annee);
		return query.getResultList();
	}

}
