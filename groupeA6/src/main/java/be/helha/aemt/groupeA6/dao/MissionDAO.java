package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.persistence.TypedQuery;

public class MissionDAO extends AbstractDAO<Mission>{

	@Override
	public Mission add(Mission t) {

		if(t==null) return null;
		if(find(t)!=null) return null;
		em.merge(t);
		submit();
		return t;
	}

	@Override
	public Mission find(Mission t) {
		if (t == null) return null;
		String strUA="SELECT mission FROM Mission mission WHERE mission.intitule=?1";
		TypedQuery<Mission> queryA=em.createQuery(strUA, Mission.class);
		queryA.setParameter(1, t.getIntitule());
		
		List<Mission> resA=queryA.getResultList();
		if(resA.isEmpty()) return null;
		Mission res = resA.get(0);
		em.detach(res);
		return res;
	}

	@Override
	public List<Mission> findAll() {
		String strFindAll = "SELECT Mission FROM Mission Mission" ;
		TypedQuery<Mission> query = em.createQuery(strFindAll,Mission.class) ;
		return query.getResultList();
	}

	@Override
	public Mission update(Mission t) {
		if (t==null) return null;
		Integer id=t.getId();
		if(id==null ||findById(id)==null) return null;
		em.merge(t);
		submit();
		em.detach(t);
		return t;
	}

	@Override
	public Mission remove(Mission t) {
		if(t==null) return null;
		Mission aSup = em.merge(t);
		em.remove(aSup);
		submit();
		return t;
	}

	@Override
	public Mission findById(Integer id) {
		if(id == null) return null;
		Mission res = em.find(Mission.class, id);
		return res;
	}
	
	public void submit() {
		tx.begin();
		tx.commit();
	}
	
	public void close()
	{
		super.close();
	}

}

