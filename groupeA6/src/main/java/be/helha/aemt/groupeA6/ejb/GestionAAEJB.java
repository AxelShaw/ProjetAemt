package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.AADAO;
import be.helha.aemt.groupeA6.entities.AA;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionAAEJB implements IGestionAAEJB {
	
	@EJB
	private AADAO daoAA;

	@Override
	public List<AA> findAll() {
		return daoAA.findAll();
	}

	@Override
	public AA findById(int id) {
		return daoAA.findById(id);
	}

	@Override
	public AA add(AA a) {
		return daoAA.add(a);
	}

	@Override
	public AA remove(AA a) {
		return daoAA.remove(a);
	}

	@Override
	public AA update(AA a) {
		return daoAA.update(a);
	}

}
