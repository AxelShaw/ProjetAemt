package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Section;
import jakarta.persistence.TypedQuery;

public class SectionDAO extends AbstractDAO<Section>{

	MissionDAO missionDAO = new MissionDAO();
	
	//Erreur lors de l'ajout, erreur impossible à localiser car message trop long
	//Trouver et corriger l'erreur
	
	@Override
	public Section add(Section t) {

		if(t==null) return null;
		if(find(t)!=null) return null;
		for(Mission m: t.getMissions())
		{
			if(missionDAO.find(m)==null) missionDAO.add(m);
		}
		em.merge(t);
		submit();
		return t;
	}

	@Override
	public Section find(Section t) {
		if (t == null) return null;
		String strUA="SELECT section FROM Section section WHERE section.nom LIKE ?1";
		TypedQuery<Section> queryA=em.createQuery(strUA, Section.class);
		queryA.setParameter(1, t.getNom());
		
		List<Section> resA=queryA.getResultList();
		if(resA.isEmpty()) return null;
		Section res = resA.get(0);
		em.detach(res);
		return res;
	}

	@Override
	public List<Section> findAll() {
		String strFindAll = "SELECT section FROM Section section" ;
		TypedQuery<Section> query = em.createQuery(strFindAll,Section.class) ;
		return query.getResultList();
	}

	@Override
	public Section update(Section t) {
		if (t==null) return null;
		Integer id=t.getId();
		if(id==null ||findById(id)==null) return null;
		em.merge(t);
		submit();
		em.detach(t);
		return t;
	}

	@Override
	public Section remove(Section t) {
		if(t==null) return null;
		Section aSup = em.merge(t);
		em.remove(aSup);
		submit();
		return t;
	}

	@Override
	public Section findById(Integer id) {
		if(id == null) return null;
		Section res = em.find(Section.class, id);
		return res;
	}
	
	public List<Mission> findMissions(Section t){
		if (t == null) return null;
		String strUA="select distinct s from Section s join fetch s.missions m where s.nom = ?1";
		TypedQuery<Mission> queryA=em.createQuery(strUA, Mission.class);
		queryA.setParameter(1, t.getNom());
		return queryA.getResultList();
		
	}
	
	public void submit() {
		tx.begin();
		tx.commit();
	}
}

