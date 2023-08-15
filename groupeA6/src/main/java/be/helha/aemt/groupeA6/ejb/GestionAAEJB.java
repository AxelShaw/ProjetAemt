package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.AADAO;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionAAEJB implements IGestionAAEJB {
	
	@EJB
	private AADAO daoAA;

	@Override
	public List<AA> findAll(String name) {
		return daoAA.findAll(name);
	}

	@Override
	public AA findById(int id) throws NotFoundException {
		return daoAA.findById(id);
	}

	@Override
	public AA add(AA a) throws NotFoundException {
		return daoAA.add(a);
	}

	@Override
	public AA remove(AA a) throws NotFoundException {
		return daoAA.remove(a);
	}

	@Override
	public AA update(AA a) throws NotFoundException {
		return daoAA.update(a);
	}

}
