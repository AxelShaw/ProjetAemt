package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Departement;
import jakarta.persistence.TypedQuery;

public class DepartementDAO extends AbstractDAO<Departement>{

	@Override
	public Departement add(Departement t) {
		if(t==null) return null;
		if(find(t)!=null) return null;
		em.merge(t);
		submit();
		return t;
	}

	@Override
	public Departement find(Departement t) {
		if (t == null) return null;
		String strUA="SELECT dep FROM Departement dep WHERE Departement.nom=?1";
		TypedQuery<Departement> queryA=em.createQuery(strUA, Departement.class);
		queryA.setParameter(1, t.getNom());
		
		List<Departement> resA=queryA.getResultList();
		if(resA.isEmpty()) return null;
		Departement res = resA.get(0);
		em.detach(res);
		return res;
	}

	@Override
	public List<Departement> findAll() {
		String strFindAll = "SELECT dep FROM Departement dep" ;
		TypedQuery<Departement> query = em.createQuery(strFindAll,Departement.class) ;
		return query.getResultList();
	}

	@Override
	public Departement update(Departement t) {
		if (t==null) return null;
		Integer id=t.getId();
		if(id==null ||findById(id)==null) return null;
		em.merge(t);
		submit();
		em.detach(t);
		return t;
	}

	@Override
	public Departement remove(Departement t) {
		if(t==null) return null;
		Departement aSup = em.merge(t);
		em.remove(aSup);
		submit();
		return t;
	}

	@Override
	public Departement findById(Integer id) {
		if(id == null) return null;
		Departement res = em.find(Departement.class, id);
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
