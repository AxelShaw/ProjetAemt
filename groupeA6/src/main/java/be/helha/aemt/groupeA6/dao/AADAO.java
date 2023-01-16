package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import jakarta.persistence.TypedQuery;

public class AADAO extends AbstractDAO<AA>{

	@Override
	public AA add(AA t) {

		if(t==null) return null;
		if(find(t)!=null) return null;
		em.merge(t);
		submit();
		return t;
	}

	@Override
	public AA find(AA t) {
		if (t == null) return null;
		String strUA="SELECT aa FROM AA aa WHERE AA.code=?1";
		TypedQuery<AA> queryA=em.createQuery(strUA, AA.class);
		queryA.setParameter(1, t.getCode());
		
		List<AA> resA=queryA.getResultList();
		if(resA.isEmpty()) return null;
		AA res = resA.get(0);
		em.detach(res);
		return res;
	}

	@Override
	public List<AA> findAll() {
		String strFindAll = "SELECT aa FROM AA aa" ;
		TypedQuery<AA> query = em.createQuery(strFindAll,AA.class) ;
		return query.getResultList();
	}

	@Override
	public AA update(AA t) {
		if (t==null) return null;
		Integer id=t.getId();
		if(id==null ||findById(id)==null) return null;
		em.merge(t);
		submit();
		em.detach(t);
		return t;
	}

	@Override
	public AA remove(AA t) {
		if(t==null) return null;
		AA aSup = em.merge(t);
		em.remove(aSup);
		submit();
		return t;
	}

	@Override
	public AA findById(Integer id) {
		if(id == null) return null;
		AA res = em.find(AA.class, id);
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

